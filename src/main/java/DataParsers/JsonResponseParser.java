package DataParsers;

import Model.City;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonResponseParser {

    public City parseResponse(String response, City city) {
        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("results");

        if (jsonArray.length() == 0) {
            return city;
        }

        JSONObject formattedAddress = jsonArray.getJSONObject(0);
        JSONObject geometry = formattedAddress.getJSONObject("geometry");
        JSONObject location = geometry.getJSONObject("location");

        String formattedCityName = formattedAddress.getString("formatted_address");
        String latitude = String.valueOf(location.getDouble("lat"));
        String longitude = String.valueOf(location.getDouble("lng"));

        city.setDetected(Boolean.TRUE);
        city.setLatitude(latitude);
        city.setLongitude(longitude);
        city.setName(formattedCityName);

        return city;
    }
}
