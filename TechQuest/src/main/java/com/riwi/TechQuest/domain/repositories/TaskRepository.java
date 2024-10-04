package com.riwi.TechQuest.domain.repositories;

import com.riwi.TechQuest.application.dto.response.TaskResponse;
import com.riwi.TechQuest.domain.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<TaskResponse> getByTitle(String title);
}
