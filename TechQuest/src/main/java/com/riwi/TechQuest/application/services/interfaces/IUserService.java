package com.riwi.TechQuest.application.services.interfaces;

import com.riwi.TechQuest.application.dto.response.UserResponse;
import com.riwi.TechQuest.domain.model.entities.UserEntity;

public interface IUserService {
    UserResponse findByEmail(String email);
    void saveUser(UserEntity userEntity);
}
