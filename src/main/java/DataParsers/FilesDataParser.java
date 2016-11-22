package DataParsers;

import Model.City;

import java.util.*;

public class FilesDataParser {
    public FilesDataParser() {
    }

    public List<City> getCities(List<String> cityNames) {
        List<City> cities = new ArrayList<>();

        for (String cityName : cityNames) {
            City newCity = new City(cityName);
            cities.add(newCity);
        }
        return cities;
    }
}
