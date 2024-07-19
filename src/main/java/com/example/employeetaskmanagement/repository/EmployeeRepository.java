package com.example.employeetaskmanagement.repository;

import com.example.employeetaskmanagement.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmail(String email);
}
