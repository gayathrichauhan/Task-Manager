package com.gayatri.smarttask.backend.service;


import com.gayatri.smarttask.backend.exceptionhandling.TaskNotFoundException;
import com.gayatri.smarttask.backend.model.Status;
import com.gayatri.smarttask.backend.model.Task;
import com.gayatri.smarttask.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {
    public List<Task> getTasksByStatus(Status status){
        return taskRepository.findByStatus(status);
    }

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
    public Task markTaskDONE(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        task.setStatus(Status.DONE);
        return taskRepository.save(task);
    }



}