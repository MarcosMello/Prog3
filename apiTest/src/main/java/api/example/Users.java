package api.example;

public record Users(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
    @Override
    public String toString() {
        return  "id: " + id() + "\n" +
                "name: " + name() + "\n" +
                "username: " + username() + "\n" +
                "email: " + email() + "\n" +
                address() +
                "phone: " + phone() + "\n" +
                "website: " + website() + "\n" +
                company();
    }
}
