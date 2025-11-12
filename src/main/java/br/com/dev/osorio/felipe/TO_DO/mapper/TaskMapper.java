package br.com.dev.osorio.felipe.TO_DO.mapper;

import br.com.dev.osorio.felipe.TO_DO.dto.TaskDTO;
import br.com.dev.osorio.felipe.TO_DO.dto.request.RegisterRequest;
import br.com.dev.osorio.felipe.TO_DO.dto.request.UpdateTaskRequest;
import br.com.dev.osorio.felipe.TO_DO.entity.TaskEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    TaskEntity fromRegisterRequest(RegisterRequest request);

    @Mapping(target = "id", ignore = true)
    TaskEntity fromUpdateTaskRequest(UpdateTaskRequest request);

    TaskEntity fromTaskDTO(TaskDTO request);

    TaskDTO fromTaskEntity(TaskEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskEntity partialUpdateTask(TaskDTO request, @MappingTarget TaskEntity entity);
}
