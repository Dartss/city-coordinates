import CitiesFinder.CoordinatesFinder;
import CitiesFinder.CoordinatesFinderImpl;
import DataParsers.FilesDataParser;
import FilesReader.FilesDataReader;
import FilesReader.FilesDataReaderImpl;
import Model.City;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainController {
    public static void main(String... args) {
        System.out.println("Enter city name, or path to the txt file. \"q\" for exit");

        FilesDataReader filesDataReader = new FilesDataReaderImpl();
        CoordinatesFinder coordinatesFinder = new CoordinatesFinderImpl();
        FilesDataParser filesDataParser = new FilesDataParser();

        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print(':');
                String input = br.readLine();

                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }

                if (!input.isEmpty()) {

                    File file = new File(input);
                    if(file.exists() && !file.isDirectory()) {
                        List<City> cities;
                        try {
                            cities = filesDataParser.getCities(filesDataReader.readFile(input));
                            coordinatesFinder.getCitiesCoordinates(cities).forEach(System.out::println);
                        } catch (IOException nsf) {
                            nsf.printStackTrace();
                        }
                    } else {
                        try {
                            City singleCity = coordinatesFinder.getCityCoordinates(new City(input));
                            if (singleCity.isDetected()){
                                System.out.println(singleCity);
                            } else {
                                throw new Exception("Not a City, and not a file path");
                            }
                        } catch (Exception e) {
                            System.out.println("Arguments were wrong, try again : " + e.getMessage());
                        }
                    }


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
