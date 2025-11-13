package br.com.dev.osorio.felipe.TO_DO.service;

import br.com.dev.osorio.felipe.TO_DO.dto.TaskDTO;
import br.com.dev.osorio.felipe.TO_DO.entity.TaskEntity;
import br.com.dev.osorio.felipe.TO_DO.mapper.TaskMapper;
import br.com.dev.osorio.felipe.TO_DO.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public TaskEntity registerTask(TaskEntity entity) {
        return taskRepository.saveAndFlush(entity);
    }

    @Transactional
    public TaskEntity partialUpdateTask(Long id, TaskDTO request) {
        TaskEntity foundTask = findTaskById(id);

        return taskMapper.partialUpdateTask(request, foundTask);
    }

    @Transactional
    public TaskEntity fullUpdateTask(Long id, TaskEntity request) {
        TaskEntity foundTask = findTaskById(id);
        request.setId(foundTask.getId());

        return registerTask(request);
    }

    @Transactional
    public void deleteTask(Long id) {
        TaskEntity task = findTaskById(id);
        taskRepository.deleteById(task.getId());
    }

    public TaskEntity findTaskById(Long id) {
        Optional<TaskEntity> task = taskRepository.findById(id);

        if (task.isEmpty()) {
            throw new EntityNotFoundException("Task not found");
        }

        return task.get();
    }
}
