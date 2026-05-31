package com.example.HealthManagement.Doctor.Repository;

import com.example.HealthManagement.Doctor.Entities.Degree;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DegreeRepository extends MongoRepository<Degree, String> {

    @Query("{degreeName:'?0'}")
    Degree findByDegreeName(String degreeName);
}
