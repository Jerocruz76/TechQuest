package com.riwi.TechQuest.domain.model.auth;

import com.riwi.TechQuest.application.dto.response.UserResponse;
import com.riwi.TechQuest.infrastructure.Jwt.JwtService;
import com.riwi.TechQuest.domain.model.enums.Roles;
import com.riwi.TechQuest.domain.model.entities.UserEntity;
import com.riwi.TechQuest.application.services.interfaces.IUserService; // Importa el UserService
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserService userService; // Cambia a IUserService
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid email or password");
        }

        UserResponse userResponse = userService.findByEmail(request.getEmail()); // Usa el UserService
        UserDetails user = new org.springframework.security.core.userdetails.User(
                userResponse.getEmail(),
                passwordEncoder.encode(request.getPassword()), // Este paso puede variar según tu lógica
                new ArrayList<>() // Proporciona los roles o authorities aquí si es necesario
        );

        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        UserEntity userEntity = UserEntity.builder()
                .name(request.getName())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.roleValueToString())
                .build();
        userService.saveUser(userEntity);

        return AuthResponse.builder()
                .token(jwtService.getToken(userEntity))
                .build();
    }
}
