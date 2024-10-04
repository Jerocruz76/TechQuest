package com.riwi.TechQuest.application.dto.response;

import com.riwi.TechQuest.domain.model.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
public class TaskResponse {
    Long id;
    String title;
    String description;
    Difficulty difficulty;
    Float progress;
    Long teacherId;
    Long studentId;
}
