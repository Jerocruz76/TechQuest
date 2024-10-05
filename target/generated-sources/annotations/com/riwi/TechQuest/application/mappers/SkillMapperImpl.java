package com.riwi.TechQuest.application.mappers;

import com.riwi.TechQuest.application.dto.request.SkillRequest;
import com.riwi.TechQuest.application.dto.response.SkillResponse;
import com.riwi.TechQuest.domain.model.entities.Skill;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-04T21:30:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class SkillMapperImpl implements SkillMapper {

    @Override
    public Skill toEntity(SkillRequest skillRequest) {
        if ( skillRequest == null ) {
            return null;
        }

        Skill.SkillBuilder skill = Skill.builder();

        skill.studentId( skillRequest.getStudentId() );
        skill.name( skillRequest.getName() );
        skill.description( skillRequest.getDescription() );

        return skill.build();
    }

    @Override
    public SkillResponse toResponse(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        SkillResponse.SkillResponseBuilder<?, ?> skillResponse = SkillResponse.builder();

        skillResponse.studentId( map( skill.getStudentId() ) );
        skillResponse.id( skill.getId() );
        skillResponse.name( skill.getName() );
        skillResponse.description( skill.getDescription() );

        return skillResponse.build();
    }
}
