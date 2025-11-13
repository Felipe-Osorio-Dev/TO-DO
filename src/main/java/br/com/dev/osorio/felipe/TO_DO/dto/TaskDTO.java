package br.com.dev.osorio.felipe.TO_DO.dto;

import java.time.LocalDate;

public record TaskDTO(
        Long id,
        String name,
        String description,
        LocalDate endTime,
        String status
) {
}
