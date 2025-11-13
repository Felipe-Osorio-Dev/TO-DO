package br.com.dev.osorio.felipe.TO_DO.dto.request;

import br.com.dev.osorio.felipe.TO_DO.util.StatusTask;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UpdateRequest(
        Long id,
        @NotBlank(message = "Nome Obrigatório!!") String name,
        @NotBlank(message = "Descrição Obrigatória!!") String description,
        @NotBlank(message = "Data de Expiração Obrigatória!!!") LocalDate endTime,
        @NotBlank(message = "Status Obrigatório!!!") StatusTask status
) {
}
