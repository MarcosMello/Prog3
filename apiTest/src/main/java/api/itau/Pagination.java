package api.itau;

public record Pagination(int page, int totalPages, int totalElements, int pageSize) {
}
