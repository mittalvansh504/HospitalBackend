package com.example.HealthManagement.Doctor.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestForHospital {
    private String hospitalName;
    private String hospitalAddress;
}
