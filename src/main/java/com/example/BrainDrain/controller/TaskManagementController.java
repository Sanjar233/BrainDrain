package com.example.BrainDrain.controller;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.service.TaskManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class TaskManagementController {
    public final TaskManagementService taskManagementService;

    @PostMapping("/create_task")
    public void createTask(@RequestBody TaskCreationRequest request){
        taskManagementService.createTask(request);
    }
    @PostMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("aaaaa");
    }
}
