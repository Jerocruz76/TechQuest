package com.riwi.TechQuest.application.dto.response;

import com.riwi.TechQuest.domain.model.entities.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
public class SkillResponse {
    private Long id;
    private String name;
    private String description;
    private Long studentId;
}
