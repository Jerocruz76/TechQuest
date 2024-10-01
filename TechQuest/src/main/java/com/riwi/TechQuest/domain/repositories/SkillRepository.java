package com.riwi.TechQuest.domain.repositories;

import com.riwi.TechQuest.domain.model.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Long> {
}
