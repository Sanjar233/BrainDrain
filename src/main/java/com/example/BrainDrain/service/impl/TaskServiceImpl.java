package com.example.BrainDrain.service.impl;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.dto.task.TaskSolvingRequest;
import com.example.BrainDrain.entities.Task;
import com.example.BrainDrain.entities.User;
import com.example.BrainDrain.enums.Role;
import com.example.BrainDrain.enums.TaskDifficulty;
import com.example.BrainDrain.exceptions.BadCredentialsException;
import com.example.BrainDrain.repositories.TaskRepository;
import com.example.BrainDrain.repositories.UserRepository;
import com.example.BrainDrain.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public TaskServiceImpl(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<String> solve_task(TaskSolvingRequest request) {
        String a = "INCORRECT";

        Optional<User> user = userRepository.findByUsername(request.getSender());
        Optional<Task> task = taskRepository.findById(request.getTask_id());
        if(task.get().getAnswer().equals(request.getAnswer())){
            task.get().setSolved(task.get().getSolved() + 1);
            user.get().setSolved_tasks(user.get().getSolved_tasks() + 1);
            user.get().setScore(user.get().getScore() + task.get().getPoints());
            if(user.get().getScore() > 100)user.get().setRank(String.valueOf(TaskDifficulty.Intermediate));
            if(user.get().getScore() > 500)user.get().setRank(String.valueOf(TaskDifficulty.Advanced));
            a = ("CORRECT");
        }
        User user1 = user.get();
        userRepository.save(user1);
        Task task1 = task.get();
        taskRepository.save(task1);
        return ResponseEntity.ok(a);
    }
}