package com.riwi.TechQuest.application.services.Impl;

import com.riwi.TechQuest.application.services.interfaces.ISkillService;
import com.riwi.TechQuest.domain.model.entities.Skill;
import com.riwi.TechQuest.domain.repositories.SkillRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class SkillService implements ISkillService {

    @Autowired
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    @Transactional
    public Skill create(Skill skill) {
        return null;
    }

    @Override
    @Transactional
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    @Transactional
    public Skill getByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public Skill update(Long aLong) {
        return null;
    }
}
