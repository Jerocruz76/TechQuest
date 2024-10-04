package com.riwi.TechQuest.application.services.Impl;

import com.riwi.TechQuest.application.dto.request.SkillRequest;
import com.riwi.TechQuest.application.dto.response.SkillResponse;
import com.riwi.TechQuest.application.services.interfaces.ISkillService;
import com.riwi.TechQuest.domain.model.entities.Skill;
import com.riwi.TechQuest.domain.model.entities.UserEntity;
import com.riwi.TechQuest.domain.repositories.SkillRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService implements ISkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    @Transactional
    public SkillResponse create(SkillRequest skillRequest) {
        try {
            Skill newSkill = Skill.builder()
                    .name(skillRequest.getName())
                    .description(skillRequest.getDescription())
                    .studentId(new UserEntity(skillRequest.getStudentId()))
                    .build();

            skillRepository.save(newSkill);

            return SkillResponse.builder()
                    .id(newSkill.getId())
                    .name(newSkill.getName())
                    .description(newSkill.getDescription())
                    .studentId(newSkill.getStudentId().getId())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error creating new skill", e);
        }
    }

    @Override
    @Transactional
    public boolean delete(Long aLong) {
        try{
            skillRepository.deleteById(aLong);
            return skillRepository.findById(aLong).isPresent();
        }catch (Exception e){
            throw new RuntimeException("Error deleting skill", e);
        }
    }

    @Override
    @Transactional
    public SkillResponse getByName(String name) {
        try {
            Optional<Skill> skillOptional = skillRepository.findByName(name);
            if (skillOptional.isPresent()) {
                Skill skill = skillOptional.get();
                return SkillResponse.builder()
                        .id(skill.getId())
                        .name(skill.getName())
                        .description(skill.getDescription())
                        .studentId(skill.getStudentId().getId())
                        .build();
            } else {
                throw new RuntimeException("Skill not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting skill by name", e);
        }
    }

    @Override
    @Transactional
    public SkillRequest update(Long id, SkillRequest skillRequest) {
        try{
            Optional<Skill> skillOptional = skillRepository.findById(id);
            if(skillOptional.isPresent()){
                Skill skill = skillOptional.get();
                return SkillRequest.builder()
                       .name(skill.getName())
                        .description(skill.getDescription())
                        .studentId(skill.getStudentId())
                       .build();
            }else{
                throw new RuntimeException("Skill not found");
            }
        }catch (Exception e){
            throw new RuntimeException("Error updating skill", e);
        }
    }
}
