package com.example.taskmonitor.dto;

import com.example.taskmonitor.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskStatusRequest {
    @NotNull
    private TaskStatus status;

    public UpdateTaskStatusRequest() {}
}
