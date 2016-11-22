package CitiesFinder;

import Model.City;

import java.util.List;

public interface CoordinatesFinder {
    List<City> getCitiesCoordinates(List<City> cities);
    City getCityCoordinates(City city);
}
