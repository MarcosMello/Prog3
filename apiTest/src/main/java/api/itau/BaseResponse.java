package api.itau;

import com.google.gson.JsonObject;

public record BaseResponse(JsonObject data, Pagination pagination) { //classe template
}
