package com.example.BrainDrain.dto.task;

import com.example.BrainDrain.enums.TaskDifficulty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreationRequest {
    private String name;
    private String description;
    private int points;
    private String category;
    private String answer;
    private String author;
    private TaskDifficulty difficulty;
}
