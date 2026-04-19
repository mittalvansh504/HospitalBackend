package com.example.HealthManagement.Departments.Entity;

import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(name = "department_name")
    private String deptName;

    private LocalDate createdOn;

    @ManyToMany(mappedBy = "departments")
    @JsonIgnore
    private Set<Doctor> doctors;

    @PrePersist
    public void setCreatedOn(){
        this.createdOn = LocalDate.now();
    }
}
