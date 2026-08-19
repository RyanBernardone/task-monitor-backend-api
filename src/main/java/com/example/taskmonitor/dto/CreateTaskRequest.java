package com.example.taskmonitor.dto;

import com.example.taskmonitor.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateTaskRequest {

    @NotBlank
    @Size(max = 100)
    private String title;

    private String description;

    @NotBlank
    private TaskPriority priority;
    private LocalDate dueDate;

    public CreateTaskRequest() {}
}
