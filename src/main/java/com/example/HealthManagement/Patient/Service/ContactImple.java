package com.example.HealthManagement.Patient.Service;



import com.example.HealthManagement.Patient.Entities.Contact;
import com.example.HealthManagement.Patient.Repository.ContactRepository;
import com.example.HealthManagement.Patient.Request.RequestForContact;
import com.example.HealthManagement.Patient.Interface.ContactInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContactImple implements ContactInterface {

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public ResponseEntity<String> receivedata(RequestForContact requestForContact){
        Contact contact = new Contact();
        contact.setName(requestForContact.getName());
        contact.setEmail(requestForContact.getEmail());
        contact.setPhoneNo(requestForContact.getPhoneNo());
        contact.setQueryArea(requestForContact.getQueryArea());
        contactRepository.save(contact);
        return ResponseEntity.ok("Contact query saved successfully");
    }
}
