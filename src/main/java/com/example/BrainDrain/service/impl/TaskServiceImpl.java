package com.example.BrainDrain.service.impl;

import com.example.BrainDrain.dto.task.TaskCreationRequest;
import com.example.BrainDrain.dto.task.TaskSolvingRequest;
import com.example.BrainDrain.entities.Task;
import com.example.BrainDrain.entities.User;
import com.example.BrainDrain.enums.Role;
import com.example.BrainDrain.exceptions.BadCredentialsException;
import com.example.BrainDrain.repositories.TaskRepository;
import com.example.BrainDrain.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void createTask(TaskCreationRequest request) {

        if (taskRepository.findByName(request.getName()).isPresent())
            throw new BadCredentialsException("Task with name: " + request.getName() + " is already exist!");
        Task task = new Task();
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        task.setPoints(request.getPoints());
        task.setDifficulty(request.getDifficulty());
        task.setCategory(request.getCategory());
        task.setAnswer(request.getAnswer());
        task.setAuthor(request.getAuthor());
        taskRepository.save(task);
    }
    @Override
    public String solve(TaskSolvingRequest request) {
        return null;
    }

}
