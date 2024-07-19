package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Task;
import com.example.employeetaskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(String id) {  // Use String instead of Long
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(String id) {  // Use String instead of Long
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByEmployeeId(String employeeId) {  // Use String instead of Long
        return taskRepository.findByEmployeeId(employeeId);
    }
}
