package com.example.HealthManagement.Doctor.Repository;


import com.example.HealthManagement.Doctor.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    boolean existsByDoctorEmail(String doctorEmail);

    boolean existsByPhoneNo(String phoneNo);



    List<Doctor> findByDepartmentsDepartmentId(Long departmentId);


    Optional<Doctor> findByDoctorEmail(String doctorEmail);

    Optional<Doctor> findByDoctorName(String doctorName);

    boolean existsByDoctorNameAndDepartments_DeptName(String doctorName, String deptName);

    boolean existsByDoctorIdAndDepartmentsDepartmentId(Long doctorId, Long departmentId);

}
