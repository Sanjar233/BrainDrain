package com.example.BrainDrain.controller;

import com.example.BrainDrain.dto.task.TaskSolvingRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/demo")
public class demoController {
    @PostMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello");
    }
}
