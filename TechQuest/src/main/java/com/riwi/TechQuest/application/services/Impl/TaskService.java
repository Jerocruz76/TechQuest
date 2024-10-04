package com.riwi.TechQuest.application.services.Impl;

import com.riwi.TechQuest.application.dto.request.TaskRequest;
import com.riwi.TechQuest.application.dto.response.TaskResponse;
import com.riwi.TechQuest.domain.model.entities.Task;
import com.riwi.TechQuest.domain.model.entities.UserEntity;
import com.riwi.TechQuest.domain.repositories.TaskRepository;
import com.riwi.TechQuest.application.services.interfaces.ITaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public TaskResponse create(TaskRequest task) {
        try{
            Task newTask = Task.builder()
                   .title(task.getTitle())
                    .description(task.getDescription())
                    .difficulty(task.getDifficulty())
                    .progress(task.getProgress())
                    .teacherId(task.getTeacherId())
                    .studentId(task.getStudentId())
                   .build();

            taskRepository.save(newTask);

            return TaskResponse.builder()
                   .title(newTask.getTitle())
                    .description(newTask.getDescription())
                    .difficulty(newTask.getDifficulty())
                    .progress(newTask.getProgress())
                    .teacherId(new UserEntity(newTask.getTeacherId()).getId())
                    .studentId(new UserEntity(newTask.getStudentId()).getId())
                            .build();
        }catch (Exception e){
            throw new RuntimeException("Error creating new task", e);
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        try{
            taskRepository.deleteById(id);
            return taskRepository.findById(id).isPresent();
        }catch (Exception e){
            throw new RuntimeException("Error deleting task", e);
        }
    }

    @Override
    public TaskResponse getByTitle(String title) {
        try{
            Optional<TaskResponse> taskOptional = taskRepository.getByTitle(title);
            if(taskOptional.isPresent()){
                return taskOptional.get();
            } else{
                throw new RuntimeException("Task not found");
            }
        }catch (Exception e){
            throw new RuntimeException("Error getting task by title", e);
        }
    }

    @Override
    public TaskRequest update(Long id, TaskRequest taskRequest) {
        try{
            Optional<Task> taskOptional = taskRepository.findById(id);
            if(taskOptional.isPresent()){
                Task task = taskOptional.get();
                return TaskRequest.builder()
                       .title(task.getTitle())
                       .description(task.getDescription())
                       .difficulty(task.getDifficulty())
                       .progress(task.getProgress())
                       .teacherId(task.getTeacherId())
                       .studentId(task.getStudentId())
                       .build();
            }else{
                throw new RuntimeException("Task not found");
            }
        }catch (Exception e){
            throw new RuntimeException("Error updating task", e);
        }
    }
}
