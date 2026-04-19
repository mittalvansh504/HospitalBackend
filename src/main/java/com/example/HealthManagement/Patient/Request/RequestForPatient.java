package com.example.HealthManagement.Patient.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestForPatient {

    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private String phoneNo;
    private String addressLine1;
    private String addressLine2;
    private String password;
    private String confirmPassword;
}
