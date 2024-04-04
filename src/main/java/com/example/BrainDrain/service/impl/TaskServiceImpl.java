package com.example.BrainDrain.service.impl;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public void createTask(TaskCreationRequest request) {
        System.out.println("0");
    }

}
