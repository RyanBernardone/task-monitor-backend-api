package com.example.taskmonitor.repository;

import com.example.taskmonitor.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
