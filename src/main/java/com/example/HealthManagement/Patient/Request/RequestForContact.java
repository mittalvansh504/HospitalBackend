package com.example.HealthManagement.Patient.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestForContact {
    private String name;
    private String email;
    private String phoneNo;
    private String queryArea;
}
