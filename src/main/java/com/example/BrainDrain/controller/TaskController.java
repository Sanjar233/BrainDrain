package com.example.BrainDrain.controller;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.dto.task.TaskSolvingRequest;
import com.example.BrainDrain.service.TaskManagementService;
import com.example.BrainDrain.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {
    public final TaskService taskService;
    @PostMapping("/solve")
    public ResponseEntity<String> solve(@RequestBody TaskSolvingRequest request){
        return taskService.solve_task(request);
    }

}

