package com.example.HealthManagement.Doctor.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NewHospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String hosId;
    private String hospitalName;
    private String hospitalAddress;

}
