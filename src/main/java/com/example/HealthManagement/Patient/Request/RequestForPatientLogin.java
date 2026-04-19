package com.example.HealthManagement.Patient.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestForPatientLogin {

    private String email;
    private String password;
}
