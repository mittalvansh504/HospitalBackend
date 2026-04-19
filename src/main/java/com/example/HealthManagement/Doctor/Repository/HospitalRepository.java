package com.example.HealthManagement.Doctor.Repository;


import com.example.HealthManagement.Doctor.Entities.NewHospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospitalRepository extends JpaRepository<NewHospital, String> {


    @Query("select h from NewHospital h where h.hospitalName=?1")
    NewHospital hospitalbynameget(String hospitalname);
}
