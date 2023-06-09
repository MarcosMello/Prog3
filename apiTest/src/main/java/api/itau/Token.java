package api.itau;

public record Token(String access_token, String token_type, String expires_in, Boolean active, String scope) {
}
