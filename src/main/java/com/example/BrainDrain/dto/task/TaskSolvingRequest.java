package com.example.BrainDrain.dto.task;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskSolvingRequest {
    private String answer;
    private String sender;
    private Long task_id;

}
