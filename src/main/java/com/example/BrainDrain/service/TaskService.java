package com.example.BrainDrain.service;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.dto.task.TaskSolvingRequest;
import org.springframework.http.ResponseEntity;

public interface TaskService {

    ResponseEntity<String> solve_task(TaskSolvingRequest request);
}
