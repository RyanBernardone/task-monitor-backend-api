package com.example.taskmonitor.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class ApiErrors {
    private final int  status;
    private final String message;
    private final LocalDateTime timestamp;
    private final Map<String, String> errors;

    public ApiErrors(int status, String message, Map<String, String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }
}
