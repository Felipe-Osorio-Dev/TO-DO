package br.com.dev.osorio.felipe.TO_DO.dto;

import br.com.dev.osorio.felipe.TO_DO.util.StatusTask;

import java.time.LocalDate;

public record TaskDTO(
        Long id,
        String name,
        String description,
        LocalDate endTime,
        StatusTask status
) {
}
