package com.example.BrainDrain.controller;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class TaskController {
    public final TaskService taskService;
    @PostMapping("/create_task")
    public void createTask(@RequestBody TaskCreationRequest request){
        taskService.createTask(request);
    }
    @PostMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("aaaaa");
        }
    }
