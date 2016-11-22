package HttpClients;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpHelperImpl implements HttpHelper {
    private HttpClient httpClient;


    public HttpHelperImpl() {
        httpClient = HttpClientBuilder.create().build();
    }

    @Override
    public String getApiResponse(String url, String city, String apiKey) throws IOException {
        HttpGet request = new HttpGet(url);
        URI uri = null;

        try {
            uri = new URIBuilder(request.getURI())
                    .addParameter("sensor", "false")
                    .addParameter("address", city).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ((HttpRequestBase) request).setURI(uri);

        HttpResponse httpResponse = httpClient.execute(request);

        return extractResponseString(httpResponse);
    }

    private String extractResponseString(HttpResponse httpResponse) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String inputLine = "";
        StringBuffer result = new StringBuffer();

        while ((inputLine = reader.readLine()) != null)
        {
            result.append(inputLine);
        }

        reader.close();
        String response = result.toString();
        return response;
    }
}
