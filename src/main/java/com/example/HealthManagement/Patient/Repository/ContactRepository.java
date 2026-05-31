package com.example.HealthManagement.Patient.Repository;


import com.example.HealthManagement.Patient.Entities.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
