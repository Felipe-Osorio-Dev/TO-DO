package br.com.dev.osorio.felipe.TO_DO.mapper;

import br.com.dev.osorio.felipe.TO_DO.dto.TaskDTO;
import br.com.dev.osorio.felipe.TO_DO.dto.request.RegisterRequest;
import br.com.dev.osorio.felipe.TO_DO.entity.TaskEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    TaskEntity toTask(RegisterRequest request);

    TaskEntity toTask(TaskDTO request);

    TaskDTO toTaskDTO(TaskEntity entity);

    RegisterRequest toRegisterRequest(TaskEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskEntity updateTask(TaskDTO request, @MappingTarget TaskEntity entity);
}
