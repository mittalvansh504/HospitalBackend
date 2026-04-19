package com.example.HealthManagement.Patient.Service;


import com.example.HealthManagement.Patient.Request.RequestForContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactMail(RequestForContact contact){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("mittalvansh504@gmail.com");
        mail.setSubject("New Patient Query");

        mail.setText(
                "Name: "+ contact.getName() + "\n"+
                "Email: " + contact.getEmail() + "\n" +
                        "Phone: " + contact.getPhoneNo() +"\n"+
                        "Query: " + contact.getQueryArea()
        );

        mailSender.send(mail);
    }
}
