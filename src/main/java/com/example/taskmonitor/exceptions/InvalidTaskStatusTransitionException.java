package com.example.taskmonitor.exceptions;

import com.example.taskmonitor.enums.TaskStatus;

public class InvalidTaskStatusTransitionException extends RuntimeException {
    public InvalidTaskStatusTransitionException(TaskStatus currentStatus, TaskStatus newStatus) {
        super("Invalid status transition from " + currentStatus + " to " + newStatus);
    }
}
