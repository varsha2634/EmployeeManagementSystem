package com.example.employeetaskmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Document(collection = "employees")
@Data
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String jobTitle;
    private Double salary;

    private List<Task> tasks;
}
