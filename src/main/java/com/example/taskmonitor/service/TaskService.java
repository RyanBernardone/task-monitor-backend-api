package com.example.taskmonitor.service;

import com.example.taskmonitor.dto.CreateTaskRequest;
import com.example.taskmonitor.dto.TaskResponse;
import com.example.taskmonitor.entity.Task;
import com.example.taskmonitor.repository.TaskRepository;
import org.springframework.stereotype.Service;

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
}
