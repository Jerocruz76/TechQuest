package com.riwi.TechQuest.domain.repositories;

import com.riwi.TechQuest.application.dto.request.SkillRequest;
import com.riwi.TechQuest.application.dto.response.SkillResponse;
import com.riwi.TechQuest.domain.model.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    Optional<Skill> findByName(String name);
}
