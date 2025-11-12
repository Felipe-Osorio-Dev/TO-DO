package br.com.dev.osorio.felipe.TO_DO.controller;

import br.com.dev.osorio.felipe.TO_DO.dto.TaskDTO;
import br.com.dev.osorio.felipe.TO_DO.dto.request.RegisterRequest;
import br.com.dev.osorio.felipe.TO_DO.dto.request.UpdateTaskRequest;
import br.com.dev.osorio.felipe.TO_DO.dto.response.RegisterResponse;
import br.com.dev.osorio.felipe.TO_DO.dto.response.UpdateTaskResponse;
import br.com.dev.osorio.felipe.TO_DO.entity.TaskEntity;
import br.com.dev.osorio.felipe.TO_DO.mapper.TaskMapper;
import br.com.dev.osorio.felipe.TO_DO.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findTaskById(@PathVariable("id") Long id) {
        TaskEntity foundTask = taskService.findTaskById(id);
        TaskDTO response = taskMapper.fromTaskEntity(foundTask);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<RegisterResponse> createTask(@Valid @RequestBody RegisterRequest request) {
        TaskEntity entity = taskMapper.fromRegisterRequest(request);
        TaskEntity taskSaved = taskService.registerTask(entity);

        RegisterResponse response = new RegisterResponse(taskSaved.getId(), taskSaved.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateTaskResponse> partialUpdateTask(@PathVariable Long id, @RequestBody TaskDTO request) {
        TaskEntity updatedTask = taskService.partialUpdateTask(id, request);
        UpdateTaskResponse response = new UpdateTaskResponse(updatedTask.getName());

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateTaskResponse> fullUpdateTask(@Valid @PathVariable Long id, @RequestBody UpdateTaskRequest request) {
        TaskEntity entity = taskMapper.fromUpdateTaskRequest(request);
        TaskEntity fullUpdateTask = taskService.fullUpdateTask(id, entity);
        UpdateTaskResponse response = new UpdateTaskResponse(fullUpdateTask.getName());


        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Task deleted");
    }
}
