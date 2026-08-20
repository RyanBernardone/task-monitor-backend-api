package com.example.taskmonitor.dto;

import com.example.taskmonitor.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateTaskRequest {

    @NotBlank
    @Size(max = 100)
    private String title;

    private String description;

    @NotNull
    private TaskPriority priority;
    private LocalDate dueDate;

    public CreateTaskRequest() {}
}
