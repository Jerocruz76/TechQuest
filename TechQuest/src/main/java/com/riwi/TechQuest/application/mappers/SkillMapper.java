package com.riwi.TechQuest.application.mappers;

import com.riwi.TechQuest.application.dto.request.SkillRequest;
import com.riwi.TechQuest.application.dto.response.SkillResponse;
import com.riwi.TechQuest.domain.model.entities.Skill;
import com.riwi.TechQuest.domain.model.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillMapper {

    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    @Mapping(source = "studentId", target = "studentId")
    Skill toEntity(SkillRequest skillRequest);

    @Mapping(source = "studentId", target = "studentId")
    SkillResponse toResponse(Skill skill);

    default Long map(UserEntity userEntity) {
        return userEntity != null ? userEntity.getId() : null;
    }
}
