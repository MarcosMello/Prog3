package api.example;

public record Address(String street, String suite, String city, String zipcode, Geo geo) {
    @Override
    public String toString() {
        return  "street: " + street() + "\n" +
                "suite: " + suite() + "\n" +
                "city: " + city() + "\n" +
                "zipcode: " + zipcode() + "\n" +
                geo().toString();
    }
}
