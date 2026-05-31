package com.example.HealthManagement.Doctor.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestForDoctor {

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

    private String confirmPassword;
}
