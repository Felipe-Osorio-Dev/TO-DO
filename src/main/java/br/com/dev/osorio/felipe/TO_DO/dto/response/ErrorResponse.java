package br.com.dev.osorio.felipe.TO_DO.dto.response;

public record ErrorResponse(
        String message,
        int status,
        String timestamp
) {
}
