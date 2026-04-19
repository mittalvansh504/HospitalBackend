package com.example.HealthManagement.Appointment.Controller;


import com.example.HealthManagement.Appointment.Interface.BookingInterface;
import com.example.HealthManagement.Appointment.Entities.BookingResponse;
import com.example.HealthManagement.Appointment.Request.DoctorHistory;
import com.example.HealthManagement.Appointment.Request.PatientHistoryData;
import com.example.HealthManagement.Appointment.Request.RequestForBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingInterface bookingInterface;

    @PostMapping
    public BookingResponse createBooking(@RequestBody RequestForBooking requestForBooking){
        return bookingInterface.bookingpatient(requestForBooking);
    }

    @GetMapping("/doctor/{doctorId}/appointments")
    public List<DoctorHistory> getallappointments(@PathVariable Long doctorId){
        return bookingInterface.getallpatient(doctorId);
    }

    @GetMapping("/patient/{patientId}/appointments")
    public List<PatientHistoryData> getallpatientappoitment(@PathVariable Long patientId){
        return bookingInterface.getalldoctor(patientId);
    }
}
