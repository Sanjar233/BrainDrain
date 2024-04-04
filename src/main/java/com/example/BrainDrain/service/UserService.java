package com.example.BrainDrain.service;

import com.example.BrainDrain.dto.user.StatResponse;
import org.springframework.stereotype.Service;


public interface UserService {
    StatResponse show_stat(String name);
}
