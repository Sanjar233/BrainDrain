package com.example.BrainDrain.repositories;

import com.example.BrainDrain.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
