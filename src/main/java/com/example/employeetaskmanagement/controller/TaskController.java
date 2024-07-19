package com.example.employeetaskmanagement.controller;

import com.example.employeetaskmanagement.model.Task;
import com.example.employeetaskmanagement.service.TaskService;
import com.example.employeetaskmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks/list";
    }

    @GetMapping("/{id}")
    public String taskDetails(@PathVariable String id, Model model) {  // Changed Long to String
        model.addAttribute("task", taskService.getTaskById(id));
        return "tasks/detail";
    }

    @GetMapping("/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "tasks/form";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTaskForm(@PathVariable String id, Model model) {  // Changed Long to String
        model.addAttribute("task", taskService.getTaskById(id));
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "tasks/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable String id) {  // Changed Long to String
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
