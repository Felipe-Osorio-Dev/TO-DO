package br.com.dev.osorio.felipe.TO_DO.dto;

import br.com.dev.osorio.felipe.TO_DO.util.PriorityTask;
import br.com.dev.osorio.felipe.TO_DO.util.StatusTask;

public record TaskDTO(
        Long id,
        String name,
        String description,
        StatusTask status,
        PriorityTask priority
) {
}
