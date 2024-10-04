package com.riwi.TechQuest.application.mappers;

import com.riwi.TechQuest.application.dto.request.SkillRequest;
import com.riwi.TechQuest.application.dto.request.TaskRequest;
import com.riwi.TechQuest.application.dto.response.SkillResponse;
import com.riwi.TechQuest.application.dto.response.TaskResponse;
import com.riwi.TechQuest.domain.model.entities.Skill;
import com.riwi.TechQuest.domain.model.entities.Task;
import com.riwi.TechQuest.domain.model.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "studentId", target = "studentId")
    Task toEntity(TaskRequest taskRequest);

    @Mapping(source = "studentId", target = "studentId")
    TaskResponse toResponse(Task task);

    default Long map(UserEntity userEntity) {
        return userEntity != null ? userEntity.getId() : null;
    }
}
