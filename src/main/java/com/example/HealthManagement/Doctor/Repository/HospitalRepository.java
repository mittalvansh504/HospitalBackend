package com.example.HealthManagement.Doctor.Repository;


import com.example.HealthManagement.Doctor.Entities.NewHospital;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface HospitalRepository extends MongoRepository<NewHospital, String> {


    @Query("select h from NewHospital h where h.hospitalName=?1")
    NewHospital hospitalbynameget(String hospitalname);
}
