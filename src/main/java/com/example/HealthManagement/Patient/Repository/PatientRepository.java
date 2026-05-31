package com.example.HealthManagement.Patient.Repository;


import com.example.HealthManagement.Patient.Entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {

    @Query("{email:'?0'}")
    Patient existsByEmail(String email);

    Optional<Patient> findByEmail(String email);

    @Query("{phoneNo:'?0'}")
    Patient existsByPhoneno(String phoneNo);

    Patient findByPatientId(String patientId);
}
