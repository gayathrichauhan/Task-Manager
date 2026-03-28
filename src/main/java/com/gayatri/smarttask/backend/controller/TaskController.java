package com.gayatri.smarttask.backend.controller;

import com.gayatri.smarttask.backend.model.Task;
import com.gayatri.smarttask.backend.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    //create
    @PostMapping
    public Task createTask(@Valid @RequestBody Task task){
        return service.createTask(task);
    }
    //read
    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }


}
