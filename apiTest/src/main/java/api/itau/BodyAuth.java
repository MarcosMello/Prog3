package api.itau;

import com.google.gson.Gson;

public record BodyAuth(String client_id, String client_secret) {
    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }
}
