package com.riwi.TechQuest.application.services.Impl;

import com.riwi.TechQuest.application.dto.response.UserResponse;
import com.riwi.TechQuest.domain.model.entities.UserEntity;
import com.riwi.TechQuest.domain.model.enums.Roles;
import com.riwi.TechQuest.domain.repositories.UserRepository;
import com.riwi.TechQuest.application.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse findByEmail(String email) {
        Optional<UserEntity> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            return UserResponse.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .role(Roles.valueOf(user.getRole().name())) // Asegúrate de que el rol sea convertible a String
                    .build();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }
}
