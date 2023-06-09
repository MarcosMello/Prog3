package api.example;

public record Comments(int postId, int id, String name, String email, String body) {
    @Override
    public String toString() {
        return  "postId: " + postId() + "\n" +
                "id: " + id() + "\n" +
                "name: " + name() + "\n" +
                "email: " + email() + "\n" +
                "body: " + body() + "\n";
    }
}
