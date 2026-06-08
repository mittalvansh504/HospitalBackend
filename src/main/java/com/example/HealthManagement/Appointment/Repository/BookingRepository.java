package com.example.HealthManagement.Appointment.Repository;

import com.example.HealthManagement.Appointment.Entities.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

    @Query("{doctorId:'?0'}")
    List<Booking> findByDoctorId(String doctorId);

    @Query("{patientId:'?0'}")
    List<Booking> findByPatientId(String patientId);

    @Query("{bookingId:'?0'}")
    Booking findByBookingId(String bookingId);
}
