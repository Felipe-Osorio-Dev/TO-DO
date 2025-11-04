package br.com.dev.osorio.felipe.TO_DO.service;

import br.com.dev.osorio.felipe.TO_DO.dto.request.CreateTaskRequest;
import br.com.dev.osorio.felipe.TO_DO.dto.response.CreateTaskResponse;
import br.com.dev.osorio.felipe.TO_DO.mapper.TaskMapper;
import br.com.dev.osorio.felipe.TO_DO.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Transactional
    public CreateTaskResponse createTask(CreateTaskRequest request) {
        var task = taskRepository.saveAndFlush(taskMapper.toTask(request));

        return new CreateTaskResponse(task.getId(), task.getName());
    }
}
