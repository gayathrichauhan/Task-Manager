package com.gayatri.smarttask.backend.repository;

import com.gayatri.smarttask.backend.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gayatri.smarttask.backend.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Status status);
}
