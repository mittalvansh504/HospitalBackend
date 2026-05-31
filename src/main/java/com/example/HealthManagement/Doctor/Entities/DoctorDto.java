package com.example.HealthManagement.Doctor.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorDto {
    private String doctorId;
    private String doctorName;
}
