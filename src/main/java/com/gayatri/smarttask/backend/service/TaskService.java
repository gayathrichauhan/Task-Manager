package com.gayatri.smarttask.backend.service;

import com.gayatri.smarttask.backend.model.Task;
import com.gayatri.smarttask.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public Task createTask(Task task){
        return repo.save(task);
    }

    public List<Task> getAllTasks(){
        return repo.findAll();
    }

    public Task updateTask(Long id, Task updatedTask){
        Task task = repo.findById(id).orElseThrow();

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription()); // ✅ fixed
        task.setStatus(updatedTask.getStatus());

        return repo.save(task);
    }

    public void deleteTask(Long id){
        repo.deleteById(id);
    }
}