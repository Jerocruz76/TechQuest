package com.riwi.TechQuest.domain.repositories;

import com.riwi.TechQuest.domain.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
