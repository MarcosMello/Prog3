package api.example;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static void main(String[] args){
        String base_url = "https://jsonplaceholder.typicode.com";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(base_url + "/todos")) // /comments or /users
                .GET()
                .build();

        Todos[] allTodos = null; //Comments[] or //Users[]

        try{
            HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());
            String response_body = response.body();

            allTodos = new GsonBuilder()
                    .create()
                    .fromJson(response_body, Todos[].class); //Comments[] or Users[]
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();

            System.exit(1);
        }

        for (Todos todo : allTodos) { //Comments or Users
            System.out.println(todo);
        }
    }
}