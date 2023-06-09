package api.example;

public record Geo(String lat, String lng) {
    @Override
    public String toString() {
        return  "lat: " + lat() + "\n" +
                "lng: " + lng() + "\n";
    }
}
