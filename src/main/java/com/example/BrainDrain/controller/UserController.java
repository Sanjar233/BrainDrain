package com.example.BrainDrain.controller;
import com.example.BrainDrain.dto.task.TaskSolvingRequest;
import com.example.BrainDrain.dto.user.StatResponse;
import com.example.BrainDrain.dto.user.UserRegisterRequest;
import com.example.BrainDrain.service.TaskService;
import com.example.BrainDrain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    public final UserService userService;
    public final TaskService taskService;
    @GetMapping("/show_stat/{name}")
    public StatResponse showStat(@PathVariable String name){
       return userService.show_stat(name);
    }
    @PostMapping("/admin")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("aaaaa");
    }
    @PostMapping("/solving")
    public String solve(@RequestBody TaskSolvingRequest request){
        return taskService.solve(request);
    }
}
