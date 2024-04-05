package com.example.BrainDrain.service;

import com.example.BrainDrain.dto.task.TaskCreationRequest;

public interface TaskManagementService {
    void createTask(TaskCreationRequest request);
}
