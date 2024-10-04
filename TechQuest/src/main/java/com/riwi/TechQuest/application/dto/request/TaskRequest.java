package com.riwi.TechQuest.application.dto.request;

import com.riwi.TechQuest.domain.model.entities.UserEntity;
import com.riwi.TechQuest.domain.model.enums.Difficulty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TaskRequest {
    @NotBlank(message = "Title is required")
    String title;
    @NotBlank(message = "Description is required")
    String description;
    @NotBlank(message = "Difficulty is required")
    Difficulty difficulty;
    @NotBlank(message = "Progress is required")
    Float progress;
    @NotBlank(message = "Teacher is required")
    UserEntity teacherId;
    @NotBlank(message = "Student is required")
    UserEntity studentId;
}
