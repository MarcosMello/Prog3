package api.itau;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    static String client_id = "";
    static String client_secret = "";
    static String base_url = "https://devportal.itau.com.br";

    public static void main(String[] args){
        String route_url = "/sandboxapi/itau-ep9-gtw-sispag-ext/v1/pagamentos_sispag";

        String response_body = getResponseBody(base_url + route_url);

        BaseResponse baseResponse = (BaseResponse) getObject(response_body, BaseResponse.class);

        PagamentosBody pagamentosBody = (PagamentosBody) getObject(baseResponse.data().toString(),
                PagamentosBody.class);

        System.out.println(pagamentosBody.itens().length);
    }

    public static String getToken(){
        String url = base_url + "/api/jwt";

        BodyAuth body = new BodyAuth(client_id,
                client_secret);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();

        String response_body = sendRequest(client, request);

        Token token = (Token) getObject(response_body, Token.class);

        return token.access_token();
    }

    public static String getResponseBody(String url){
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("x-itau-apikey", client_id)
                .header("x-sandbox-token", getToken())
                .GET()
                .build();

        return sendRequest(client, request);
    }

    public static String sendRequest(HttpClient client, HttpRequest request){
        String response_body = null;

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            response_body = response.body();
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();

            System.exit(1);
        }

        return response_body;
    }

    public static Object getObject(String response_body, Type objClass){
        Object convertedObject = null;

        try{
            convertedObject = new GsonBuilder()
                                .create()
                                .fromJson(response_body, objClass);
        } catch (JsonParseException exception){
            exception.printStackTrace();

            System.exit(1);
        }

        return convertedObject;
    }
}
