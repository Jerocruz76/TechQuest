package com.riwi.TechQuest.domain.repositories;

import com.riwi.TechQuest.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
