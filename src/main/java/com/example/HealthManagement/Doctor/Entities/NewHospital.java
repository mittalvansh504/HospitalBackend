package com.example.HealthManagement.Doctor.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hospital")
public class NewHospital {

    @Id
    private String hosId;
    private String hospitalName;
    private String hospitalAddress;

}
