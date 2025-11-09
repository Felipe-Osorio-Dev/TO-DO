package br.com.dev.osorio.felipe.TO_DO.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterRequest(
        @NotBlank(message = "Nome Obrigatório!!")
        String name,
        String description,
        LocalDate endTime,
        String status
) {
}
