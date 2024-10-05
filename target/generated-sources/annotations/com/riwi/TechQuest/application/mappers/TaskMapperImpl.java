package com.riwi.TechQuest.application.mappers;

import com.riwi.TechQuest.application.dto.request.TaskRequest;
import com.riwi.TechQuest.application.dto.response.TaskResponse;
import com.riwi.TechQuest.domain.model.entities.Task;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-04T21:30:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toEntity(TaskRequest taskRequest) {
        if ( taskRequest == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.studentId( taskRequest.getStudentId() );
        task.title( taskRequest.getTitle() );
        task.description( taskRequest.getDescription() );
        task.difficulty( taskRequest.getDifficulty() );
        task.progress( taskRequest.getProgress() );
        task.teacherId( taskRequest.getTeacherId() );

        return task.build();
    }

    @Override
    public TaskResponse toResponse(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskResponse.TaskResponseBuilder<?, ?> taskResponse = TaskResponse.builder();

        taskResponse.studentId( map( task.getStudentId() ) );
        taskResponse.id( task.getId() );
        taskResponse.title( task.getTitle() );
        taskResponse.description( task.getDescription() );
        taskResponse.difficulty( task.getDifficulty() );
        taskResponse.progress( task.getProgress() );
        taskResponse.teacherId( map( task.getTeacherId() ) );

        return taskResponse.build();
    }
}
