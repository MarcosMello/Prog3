package api.example;

public class Todos {
    private final int userId;
    private final int id;
    private final String title;
    private final Boolean completed;

    public Todos(int userId, int id, String title, Boolean completed){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    @Override
    public java.lang.String toString() {
        return "userId: " + getUserId() + "\n" +
                "id: " + getId() + "\n" +
                "title: " + getTitle() + "\n" +
                "completed: " + getCompleted() + "\n";
    }
}
