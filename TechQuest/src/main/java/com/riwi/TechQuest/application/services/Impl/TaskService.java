package com.riwi.TechQuest.application.services.Impl;

import com.riwi.TechQuest.domain.model.entities.Task;
import com.riwi.TechQuest.domain.repositories.TaskRepository;
import com.riwi.TechQuest.application.services.interfaces.ITaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskService implements ITaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public Task create(Task task) {
        return null;
    }

    @Override
    @Transactional
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    @Transactional
    public Task getByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public Task update(Long aLong) {
        return null;
    }
}
