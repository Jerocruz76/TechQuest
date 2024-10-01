package com.riwi.TechQuest.domain.repositories;

import com.riwi.TechQuest.domain.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String name);
    Optional<UserEntity> findByEmail(String email);
}
