package com.riwi.TechQuest.domain.auth;

import com.riwi.TechQuest.Jwt.JwtService;
import com.riwi.TechQuest.application.utils.enums.Roles;
import com.riwi.TechQuest.domain.entities.UserEntity;
import com.riwi.TechQuest.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request){
        return null;
    }

    public AuthResponse register(RegisterRequest request){
        UserEntity userEntity = UserEntity.builder()
                .name(request.getName())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Roles.STUDENT)
                .build();
        userRepository.save(userEntity);
        return AuthResponse.builder()
                .token(jwtService.getToken(userEntity))
                .build();
    }
}
