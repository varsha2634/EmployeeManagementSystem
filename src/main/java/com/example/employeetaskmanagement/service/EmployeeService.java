package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(String id);
}
