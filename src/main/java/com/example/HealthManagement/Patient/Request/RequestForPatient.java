package com.example.HealthManagement.Patient.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestForPatient {

    private String patientName;
    private String email;
    private String phoneNo;
    private LocalDate patientDOB;
    private String fatherName;
    private String motherName;

    private String permanentAddress;
    private String currentAddress;
    private String password;
    private String confirmPassword;
}
