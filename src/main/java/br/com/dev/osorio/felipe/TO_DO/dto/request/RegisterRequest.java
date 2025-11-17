package br.com.dev.osorio.felipe.TO_DO.dto.request;

import br.com.dev.osorio.felipe.TO_DO.util.PriorityTask;
import br.com.dev.osorio.felipe.TO_DO.util.StatusTask;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterRequest(
        @NotBlank(message = "Nome Obrigatório!!")
        String name,
        String description,
        StatusTask status,
        PriorityTask priority
) {
}
