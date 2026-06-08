package com.example.HealthManagement.Appointment.Interface;


import com.example.HealthManagement.Appointment.Entities.BookingHistoryResponse;
import com.example.HealthManagement.Appointment.Entities.BookingResponse;
import com.example.HealthManagement.Appointment.Request.RequestForBooking;

import java.util.List;

public interface BookingInterface {

    BookingResponse createBooking(RequestForBooking requestForBooking);

    List<BookingHistoryResponse> getAllAppointmentsForDoctor(String doctorId);

    List<BookingHistoryResponse> getAllAppointmentsForPatient(String patientId);

    String markVisited(String bookingId);
}
