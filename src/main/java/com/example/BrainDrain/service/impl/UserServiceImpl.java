package com.example.BrainDrain.service.impl;

import com.example.BrainDrain.dto.user.StatResponse;
import com.example.BrainDrain.entities.User;
import com.example.BrainDrain.repositories.UserRepository;
import com.example.BrainDrain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    @Override
    public StatResponse show_stat(String name){
        User user = userRepository.findByUsername(name).orElseThrow();
        StatResponse response = new StatResponse();
        response.setRank(user.getRank());
        response.setScore(user.getScore());
        response.setCreated_tasks(user.getCreated_tasks());
        response.setSolved_tasks(user.getSolved_tasks());
        return response;
    }
}
