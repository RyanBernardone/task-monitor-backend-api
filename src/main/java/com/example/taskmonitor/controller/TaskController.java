package com.example.taskmonitor.controller;

import com.example.taskmonitor.dto.CreateTaskRequest;
import com.example.taskmonitor.dto.TaskResponse;
import com.example.taskmonitor.dto.UpdateTaskRequest;
import com.example.taskmonitor.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(@RequestBody TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@Valid @RequestBody CreateTaskRequest request) {
        return taskService.create(request);
    }

    @GetMapping("/{id}")
    public TaskResponse findById(@PathVariable Long id) {
        return  taskService.findById(id);
    }

    @GetMapping
    public List<TaskResponse> findAll(){
        return taskService.findAll();
    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @Valid @RequestBody UpdateTaskRequest request) {
        return taskService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
