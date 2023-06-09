package api.example;

public record Company(String name, String catchPhrase, String bs) {
    @Override
    public String toString() {
        return  "name: " + name() + "\n" +
                "catchPhrase: " + catchPhrase() + "\n" +
                "bs: " + bs() + "\n";
    }
}
