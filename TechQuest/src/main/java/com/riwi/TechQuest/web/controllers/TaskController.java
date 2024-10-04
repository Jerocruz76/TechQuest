package com.riwi.TechQuest.web.controllers;

import com.riwi.TechQuest.application.dto.request.TaskRequest;
import com.riwi.TechQuest.application.dto.response.TaskResponse;
import com.riwi.TechQuest.application.services.Impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponse> create(@RequestBody TaskRequest request){
        TaskResponse task = taskService.create(request);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<TaskResponse> findByTitle(@PathVariable String title){
        TaskResponse task = taskService.getByTitle(title);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<TaskRequest> update(@PathVariable Long id, @RequestBody TaskRequest request){
        TaskRequest task = taskService.update(id, request);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
