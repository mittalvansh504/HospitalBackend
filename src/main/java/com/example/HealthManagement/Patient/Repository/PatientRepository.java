package com.example.HealthManagement.Patient.Repository;


import com.example.HealthManagement.Patient.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.email=?1")
    Patient existsByEmail(String email);

    @Query("select p from Patient p where p.phoneNo=?1")
    Patient existsByPhoneno(String phoneno);

    @Query("select p from Patient p where p.firstName=?1")
    Patient getpatientbyname(String name);

    @Query("select p from Patient p where p.email=?1")
    Patient getpatient(String email_id);


    Optional<Patient> findByEmailAndPassword(String email, String password);

    Optional<Patient> findByEmail(String email);
}
