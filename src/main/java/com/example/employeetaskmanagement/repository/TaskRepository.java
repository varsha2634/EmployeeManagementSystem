package com.example.employeetaskmanagement.repository;

import com.example.employeetaskmanagement.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByEmployeeId(String employeeId);
}
