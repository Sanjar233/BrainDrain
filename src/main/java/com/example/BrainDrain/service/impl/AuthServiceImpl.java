package com.example.BrainDrain.service.impl;

import com.example.BrainDrain.config.JwtService;
import com.example.BrainDrain.dto.user.AuthLoginRequest;
import com.example.BrainDrain.dto.user.AuthLoginResponse;
import com.example.BrainDrain.dto.user.UserRegisterRequest;
import com.example.BrainDrain.dto.user.UserRegisterResponse;
import com.example.BrainDrain.entities.User;
import com.example.BrainDrain.entities.Token;
import com.example.BrainDrain.enums.Role;
import com.example.BrainDrain.enums.TaskDifficulty;
import com.example.BrainDrain.enums.TokenType;
import com.example.BrainDrain.exceptions.BadCredentialsException;
import com.example.BrainDrain.exceptions.BadRequestException;
import com.example.BrainDrain.repositories.UserRepository;
import com.example.BrainDrain.repositories.TokenRepository;
import com.example.BrainDrain.service.AuthService;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
//    @Autowired
//    private JavaMailSender mailSender;
//
    @Override
    public UserRegisterResponse register(UserRegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent())
            throw new BadCredentialsException("User with username: " + request.getUsername() + " is already exist!");
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(Role.USER);
        user.setScore(0);
        user.setRank(String.valueOf(TaskDifficulty.Beginner));
        user.setSolved_tasks(0);
        user.setCreated_tasks(0);
        userRepository.save(user);

        String token = jwtService.generateToken(user);
        System.out.println(token);
        return new UserRegisterResponse(token);
    }
    @Override
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest) {
        User user = userRepository.findByUsername(authLoginRequest.getUsername()).orElseThrow();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authLoginRequest.getUsername(),
                            authLoginRequest.getPassword()
                    ));
        }catch (org.springframework.security.authentication.BadCredentialsException e){
            throw new BadCredentialsException("Credentials are incorrect!");
        }
        String token = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, token);
//        return new AuthLoginResponse(token);
        return AuthLoginResponse.builder()
            .accessToken(token)
            .build();
    }
    public void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
          return;
        validUserTokens.forEach(token -> {
          token.setExpired(true);
          token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
    public void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
        tokenRepository.save(token);
    }

}
