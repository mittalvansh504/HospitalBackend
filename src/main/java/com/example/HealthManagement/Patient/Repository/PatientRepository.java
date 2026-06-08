package com.example.HealthManagement.Patient.Repository;


import com.example.HealthManagement.Patient.Entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {

    @Query("{email:'?0'}")
    Patient existsByEmail(String email);

    Optional<Patient> findByEmail(String email);

    @Query("{phoneNo:'?0'}")
    Patient existsByPhoneno(String phoneNo);

    @Query("{patientId:'?0'}")
    Patient findByPatientId(String patientId);
}
