package HttpClients;

import java.io.IOException;

public interface HttpHelper {
    String getApiResponse(String url, String city, String apiKey) throws IOException;
}
