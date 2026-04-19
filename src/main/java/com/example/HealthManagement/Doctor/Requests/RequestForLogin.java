package com.example.HealthManagement.Doctor.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestForLogin {
    private String doctorEmail;
    private String password;
}
