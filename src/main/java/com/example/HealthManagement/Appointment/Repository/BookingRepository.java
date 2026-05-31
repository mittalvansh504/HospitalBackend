package com.example.HealthManagement.Appointment.Repository;


import com.example.HealthManagement.Appointment.Entities.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {


    List<Booking> findByDoctorId(String doctorId);

    List<Booking> findByPatientId(String patientId);
}
