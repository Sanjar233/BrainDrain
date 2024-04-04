package com.example.BrainDrain.controller;
import com.example.BrainDrain.dto.user.StatResponse;
import com.example.BrainDrain.dto.user.UserRegisterRequest;
import com.example.BrainDrain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    public final UserService userService;
    @GetMapping("/show_stat/{name}")
    public StatResponse showStat(@PathVariable String name){
       return userService.show_stat(name);
    }
    @PostMapping("/demo")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("aaaaa");
    }
}
