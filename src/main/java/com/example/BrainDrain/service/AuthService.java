package com.example.BrainDrain.service;

import com.example.BrainDrain.dto.user.AuthLoginRequest;
import com.example.BrainDrain.dto.user.AuthLoginResponse;
import com.example.BrainDrain.dto.user.UserRegisterRequest;
import com.example.BrainDrain.dto.user.UserRegisterResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);
    AuthLoginResponse login(AuthLoginRequest authLoginRequest);
}
