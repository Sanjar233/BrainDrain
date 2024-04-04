package com.example.BrainDrain.dto.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StatResponse {
    private int score;
    private String rank;
    private int created_tasks;
    private int solved_tasks;

}
