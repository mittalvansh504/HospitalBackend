package com.example.HealthManagement.Appointment.Repository;


import com.example.HealthManagement.Appointment.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {


    List<Booking> findByDoctorDoctorId(Long doctorId);

    List<Booking> findByPatientPatientId(Long patientId);
}
