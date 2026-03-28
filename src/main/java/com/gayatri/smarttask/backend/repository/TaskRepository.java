package com.gayatri.smarttask.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gayatri.smarttask.backend.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
