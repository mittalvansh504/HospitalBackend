package com.example.HealthManagement.Appointment.Interface;


import com.example.HealthManagement.Appointment.Entities.Booking;
import com.example.HealthManagement.Appointment.Entities.BookingResponse;
import com.example.HealthManagement.Appointment.Request.RequestForBooking;

import java.util.List;

public interface BookingInterface {

    BookingResponse createBooking(RequestForBooking requestForBooking);

    List<Booking> getAllAppointmentsForDoctor(String doctorId);

    List<Booking> getAllAppointmentsForPatient(String patientId);


}
