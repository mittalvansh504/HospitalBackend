package com.example.HealthManagement.Doctor.Requests;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestForDoctor {
    private String doctorName;
    private String doctorEmail;
    private String phoneNo;
    private LocalDate doctorDob;
    private String degree;
    private Set<String> departmentNames;
    private String addressLine1;
    private String addressLine2;
    private String password;
    private String confirmPassword;
}
