package com.example.BrainDrain.controller;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class TaskController {
    public final TaskService taskService;
    @PostMapping("/admin")
    public void createTask(@PathVariable TaskCreationRequest request){
        taskService.createTask(request);
    }
}
