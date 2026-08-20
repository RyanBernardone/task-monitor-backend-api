package com.example.taskmonitor.service;

import com.example.taskmonitor.dto.CreateTaskRequest;
import com.example.taskmonitor.dto.TaskResponse;
import com.example.taskmonitor.dto.UpdateTaskRequest;
import com.example.taskmonitor.entity.Task;
import com.example.taskmonitor.exceptions.TaskNotFoundException;
import com.example.taskmonitor.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse create(CreateTaskRequest request) {
        Task task = new Task(
                request.getTitle(),
                request.getDescription(),
                request.getPriority(),
                request.getDueDate()
        );

        Task savedTask = taskRepository.save(task);
        return TaskResponse.from(savedTask);
    }

    public TaskResponse findById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return TaskResponse.from(task);
    }

    public List<TaskResponse> findAll() {
        return taskRepository.findAll().stream().map(TaskResponse::from).toList();
    }

    public TaskResponse update(Long id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

        task.update(
                request.getTitle(),
                request.getDescription(),
                request.getPriority(),
                request.getDueDate()
        );

        Task updatedTask = taskRepository.save(task);
        return TaskResponse.from(updatedTask);
    }
}
