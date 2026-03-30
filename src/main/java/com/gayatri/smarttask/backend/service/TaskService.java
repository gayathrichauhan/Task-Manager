package com.gayatri.smarttask.backend.service;


import com.gayatri.smarttask.backend.exceptionhandling.TaskNotFoundException;
import com.gayatri.smarttask.backend.model.Task;
import com.gayatri.smarttask.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task){

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long Id){
        return taskRepository.findById(Id)
                .orElseThrow(() -> new TaskNotFoundException("task not found with id:"+ Id));
    }

    public Task updateTask(Long id, Task updatedTask){
        Task task = taskRepository.findById(id).orElseThrow();

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription()); // ✅ fixed
        task.setStatus(updatedTask.getStatus());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new TaskNotFoundException("task not found wih id:"+id));
        taskRepository.delete(task);
    }



}