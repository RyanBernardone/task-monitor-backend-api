package com.example.taskmonitor.service;

import com.example.taskmonitor.dto.CreateTaskRequest;
import com.example.taskmonitor.entity.Task;
import com.example.taskmonitor.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(CreateTaskRequest request) {
        Task task = new Task(
                request.getTitle(),
                request.getDescription(),
                request.getPriority(),
                request.getDueDate()
        );

        return taskRepository.save(task);
    }
}
