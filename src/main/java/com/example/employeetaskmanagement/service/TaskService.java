package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(String id);  // Use String instead of Long
    Task saveTask(Task task);
    void deleteTask(String id);   // Use String instead of Long
    List<Task> getTasksByEmployeeId(String employeeId);  // Use String instead of Long
}
