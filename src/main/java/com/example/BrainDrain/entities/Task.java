package com.example.BrainDrain.entities;

import com.example.BrainDrain.enums.TaskDifficulty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "task_table")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int points;
    private String category;

    private String answer;
    private int solved;
    private String author;
    private TaskDifficulty difficulty;
}