package br.com.dev.osorio.felipe.TO_DO.mapper;

import br.com.dev.osorio.felipe.TO_DO.dto.request.CreateTaskRequest;
import br.com.dev.osorio.felipe.TO_DO.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    TaskEntity toTask(CreateTaskRequest request);
}
