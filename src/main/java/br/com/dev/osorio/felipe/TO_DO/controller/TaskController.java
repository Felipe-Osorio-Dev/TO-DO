package br.com.dev.osorio.felipe.TO_DO.controller;

import br.com.dev.osorio.felipe.TO_DO.dto.TaskDTO;
import br.com.dev.osorio.felipe.TO_DO.dto.request.RegisterRequest;
import br.com.dev.osorio.felipe.TO_DO.dto.response.RegisterResponse;
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

    @GetMapping
    public ResponseEntity<TaskDTO> findTaskById(@RequestParam("id") Long id) {
        TaskDTO task = taskService.findTaskById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(task);
    }

    @PostMapping("/create")
    public ResponseEntity<RegisterResponse> createTask(@Valid @RequestBody RegisterRequest request) {
        var response = taskService.registerTask(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RegisterResponse> updateTask(@PathVariable Long id, @RequestBody TaskDTO request) {
        var response = taskService.updateTask(id, request);

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
