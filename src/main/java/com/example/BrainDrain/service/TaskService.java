package com.example.BrainDrain.service;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.dto.task.TaskSolvingRequest;

public interface TaskService {
    void createTask(TaskCreationRequest request);
    String solve(TaskSolvingRequest request);
}
