package com.riwi.TechQuest.application.dto.request;
import com.riwi.TechQuest.domain.model.entities.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SkillRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Student is required")
    private UserEntity studentId;
}
