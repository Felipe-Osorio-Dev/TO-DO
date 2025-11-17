package br.com.dev.osorio.felipe.TO_DO.dto.request;

import br.com.dev.osorio.felipe.TO_DO.util.PriorityTask;
import br.com.dev.osorio.felipe.TO_DO.util.StatusTask;
import jakarta.validation.constraints.NotBlank;

public record UpdateRequest(
        Long id,
        @NotBlank(message = "Nome Obrigatório!!") String name,
        @NotBlank(message = "Descrição Obrigatória!!") String description,
        @NotBlank(message = "Status Obrigatório!!!") StatusTask status,
        @NotBlank(message = "Prioridade Obrigatória!!!") PriorityTask priority
) {
}
