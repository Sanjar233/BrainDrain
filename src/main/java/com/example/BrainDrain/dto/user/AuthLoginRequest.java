package com.example.BrainDrain.dto.user;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthLoginRequest {
    private String username;
    String password;
}
