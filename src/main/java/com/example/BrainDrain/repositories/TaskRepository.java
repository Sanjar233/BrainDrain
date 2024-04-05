package com.example.BrainDrain.repositories;

import com.example.BrainDrain.entities.Task;

import com.example.BrainDrain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Optional<Task> findByName(String name);
}
