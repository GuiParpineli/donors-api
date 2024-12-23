package br.com.donor.donorsapi.domain.model;

public record DefaultResponse(
        int code,
        String message
) {
    public static DefaultResponse succefully() {
        return new DefaultResponse(201, "Registered successfully");
    }
}
