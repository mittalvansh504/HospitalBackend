package com.example.HealthManagement.Doctor.Repository;


import com.example.HealthManagement.Doctor.Entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

    boolean existsByDoctorEmail(String doctorEmail);

    boolean existsByPhoneNo(String phoneNo);

    Optional<Doctor> findByDoctorEmail(String doctorEmail);

    Doctor findByDoctorId(String doctorId);

    List<Doctor> findByDepartmentId(String departmentId);
}
