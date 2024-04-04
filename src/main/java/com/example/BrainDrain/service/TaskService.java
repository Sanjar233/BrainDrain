package com.example.BrainDrain.service;

import com.example.BrainDrain.dto.task.TaskCreationRequest;

public interface TaskService {
    void createTask(TaskCreationRequest request);
}
