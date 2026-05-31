package com.example.HealthManagement.Departments.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "department")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

    @Id
    private String departmentId;

    private String deptName;

    private LocalDate createdOn = LocalDate.now();

    private boolean active = true;

}
