package com.example.HealthManagement.Patient.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "contact")
public class Contact {

    @Id
    private String contactId;
    private String name;
    private String email;
    private String phoneNo;
    private String queryArea;
}
