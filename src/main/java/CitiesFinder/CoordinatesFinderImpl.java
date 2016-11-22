package CitiesFinder;

import DataParsers.JsonResponseParser;
import HttpClients.HttpHelper;
import HttpClients.HttpHelperImpl;
import Model.City;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoordinatesFinderImpl implements CoordinatesFinder {
    private static final String GOOGLE_GEO_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?";

    private HttpHelper httpHelper;
    private JsonResponseParser jsonResponseParser;

    public CoordinatesFinderImpl() {
        jsonResponseParser = new JsonResponseParser();
        httpHelper = new HttpHelperImpl();
    }

    @Override
    public List<City> getCitiesCoordinates(List<City> cities) {
        String response = "";
        List<City> citiesCoordinates = new ArrayList<>();

        for (City city : cities) {
            try {
                response = httpHelper.getApiResponse(GOOGLE_GEO_API_URL, city.getName(), null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            citiesCoordinates.add(jsonResponseParser.parseResponse(response, city));
        }

        return citiesCoordinates;
    }

    @Override
    public City getCityCoordinates(City city) {
        String response = "";
        try {
            response = httpHelper.getApiResponse(GOOGLE_GEO_API_URL, city.getName(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResponseParser.parseResponse(response, city);
    }
}
