package com.example.HealthManagement.Doctor.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    private String doctorId;
    private String doctorName;
    private String doctorEmail;
    private String phoneNo;
    private LocalDate doctorDob;
    private String degree;
    private int experience;

    private String departmentName;

    private String addressLine1;
    private String addressLine2;

    private String password;
    @Transient
    private String confirmPassword;

    private LocalDate createdOn = LocalDate.now();
    private boolean active = true;
}
