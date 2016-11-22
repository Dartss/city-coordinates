package Model;

public class City {
    private String latitude;
    private String longitude;

    private boolean isDetected;

    private String name;

    public City(String name) {
        this.name = name;
        this.longitude = "Unknown";
        this.latitude = "Unknown";
        this.isDetected = Boolean.FALSE;
    }

    public City(String latitude, String longitude, String city) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = city;
        this.isDetected = Boolean.FALSE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public boolean isDetected() {
        return isDetected;
    }

    public void setDetected(boolean detected) {
        this.isDetected = detected;
    }

    @Override
    public String toString() {
        return "City: " + name + "\n" +
                "latitude = '" + latitude + '\'' + "\n" +
                "longitude = '" + longitude + "\n";
    }
}
