package com.example.HealthManagement.Patient.Controller;


import com.example.HealthManagement.Patient.Service.EmailService;
import com.example.HealthManagement.Patient.Request.RequestForContact;
import com.example.HealthManagement.Patient.Interface.ContactInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Contact")
public class ContactController {

    @Autowired
    private ContactInterface contactInterface;

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendingmessage(@RequestBody RequestForContact requestForContact){
        ResponseEntity<String> response = contactInterface.receivedata(requestForContact);
        emailService.sendContactMail(requestForContact);
        return response;
    }

}
