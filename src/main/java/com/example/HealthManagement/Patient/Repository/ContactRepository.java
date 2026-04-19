package com.example.HealthManagement.Patient.Repository;


import com.example.HealthManagement.Patient.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {

}
