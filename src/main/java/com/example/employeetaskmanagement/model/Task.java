package com.example.employeetaskmanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate deadline;
    private TaskStatus status;
    private String employeeId;

    public enum TaskStatus {
        PENDING, IN_PROGRESS, COMPLETED
    }
}
