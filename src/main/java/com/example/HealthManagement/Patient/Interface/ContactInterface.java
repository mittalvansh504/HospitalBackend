package com.example.HealthManagement.Patient.Interface;


import com.example.HealthManagement.Patient.Request.RequestForContact;
import org.springframework.http.ResponseEntity;

public interface ContactInterface {
    ResponseEntity<String> receivedata(RequestForContact requestForContact);

}
