package com.example.HealthManagement.Appointment.Interface;


import com.example.HealthManagement.Appointment.Entities.BookingResponse;
import com.example.HealthManagement.Appointment.Request.DoctorHistory;
import com.example.HealthManagement.Appointment.Request.PatientHistoryData;
import com.example.HealthManagement.Appointment.Request.RequestForBooking;

import java.util.List;

public interface BookingInterface {

    BookingResponse bookingpatient(RequestForBooking requestForBooking);

    List<DoctorHistory> getallpatient(Long doctorId);

    List<PatientHistoryData> getalldoctor(Long patientId);
}
