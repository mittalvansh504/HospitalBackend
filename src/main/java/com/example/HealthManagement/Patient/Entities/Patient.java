package com.example.HealthManagement.Patient.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "patient")
public class Patient {

    @Id
    private String patientId;
    private String patientName;
    private String email;
    private String phoneNo;
    private LocalDate patientDOB;
    private String fatherName;
    private String motherName;

    private String permanentAddress;
    private String currentAddress;
    private String password;

    @Transient
    private String confirmPassword;

    private LocalDateTime createdOn = LocalDateTime.now();
    private boolean active = true;
}
