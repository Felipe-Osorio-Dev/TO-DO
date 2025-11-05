package br.com.dev.osorio.felipe.TO_DO.controller;

import br.com.dev.osorio.felipe.TO_DO.dto.request.CreateTaskRequest;
import br.com.dev.osorio.felipe.TO_DO.dto.response.CreateTaskResponse;
import br.com.dev.osorio.felipe.TO_DO.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateTaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request) {
        var response = taskService.createTask(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Task deleted");
    }
}
