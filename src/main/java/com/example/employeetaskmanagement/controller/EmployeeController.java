package com.example.employeetaskmanagement.controller;

import com.example.employeetaskmanagement.model.Employee;
import com.example.employeetaskmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees/list";
    }

    @GetMapping("/{id}")
    public String employeeDetails(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employees/detail";
    }

    @GetMapping("/new")
    public String newEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/form";
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String editEmployeeForm(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employees/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}