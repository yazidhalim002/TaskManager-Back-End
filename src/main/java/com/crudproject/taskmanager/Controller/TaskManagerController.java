package com.crudproject.taskmanager.Controller;

import com.crudproject.taskmanager.DTO.TaskManagerDTO;
import com.crudproject.taskmanager.Enum.Status;
import com.crudproject.taskmanager.Service.TaskManagerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskManagerController {

    private final TaskManagerService taskManagerService;

    public TaskManagerController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    // Get all tasks
    @GetMapping
    public List<TaskManagerDTO> getAllTasks() {
        return taskManagerService.getAllTasks();
    }

    // Get one task by ID
    @GetMapping("/{id}")
    public Optional<TaskManagerDTO> getTaskById(@PathVariable Long id) {
        return taskManagerService.getTaskById(id);
    }

    // Create a new task
    @PostMapping
    public TaskManagerDTO addTask(@RequestBody TaskManagerDTO taskManagerDTO) {
        return taskManagerService.addTask(taskManagerDTO);
    }

    // Update an existing task
    @PutMapping("/{id}")
    public Optional<TaskManagerDTO> updateTask(
            @PathVariable Long id,
            @RequestBody TaskManagerDTO taskManagerDTO) {
        return taskManagerService.updateTask(id, taskManagerDTO);
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskManagerService.deleteTask(id);
    }

    // Change task status
    @PatchMapping("/{id}/status")
    public TaskManagerDTO changeStatus(
            @PathVariable Long id,
            @RequestParam Status status) {
        return taskManagerService.changeStatus(id, status);
    }
}
