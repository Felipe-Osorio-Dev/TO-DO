package br.com.dev.osorio.felipe.TO_DO.service;

import br.com.dev.osorio.felipe.TO_DO.dto.TaskDTO;
import br.com.dev.osorio.felipe.TO_DO.dto.request.RegisterRequest;
import br.com.dev.osorio.felipe.TO_DO.dto.response.RegisterResponse;
import br.com.dev.osorio.felipe.TO_DO.entity.TaskEntity;
import br.com.dev.osorio.felipe.TO_DO.mapper.TaskMapper;
import br.com.dev.osorio.felipe.TO_DO.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Transactional
    public RegisterResponse registerTask(RegisterRequest request) {
        var task = taskRepository.saveAndFlush(taskMapper.toTask(request));

        return new RegisterResponse(task.getId(), task.getName());
    }

    @Transactional
    public RegisterResponse updateTask(Long id, TaskDTO request) {
        TaskDTO findTask = findTaskById(id);
        TaskEntity entity = taskMapper.toTask(findTask);
        TaskEntity updateEntity = taskMapper.updateTask(request, entity);

        return registerTask(taskMapper.toRegisterRequest(updateEntity));
    }

    @Transactional
    public void deleteTask(Long id) {
        var task = findTaskById(id);

        taskRepository.deleteById(task.id());
    }

    public TaskDTO findTaskById(Long id) {
        Optional<TaskEntity> task = taskRepository.findById(id);

        if (!task.isPresent()) {
            throw new RuntimeException("Task not found");
        }

        return taskMapper.toTaskDTO(task.get());
    }
}
