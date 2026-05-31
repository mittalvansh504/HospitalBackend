package com.example.HealthManagement.Appointment.Controller;


import com.example.HealthManagement.Appointment.Entities.Booking;
import com.example.HealthManagement.Appointment.Interface.BookingInterface;
import com.example.HealthManagement.Appointment.Entities.BookingResponse;
import com.example.HealthManagement.Appointment.Request.RequestForBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    private static final Logger logger = Logger.getLogger(String.valueOf(BookingController.class));

    @Autowired
    private BookingInterface bookingInterface;

//    @GetMapping("/gettingpatientdata/{patientId}")
//    public Patient gettingpatientdata(@PathVariable String patientId){
//        return bookingInterface.gettingpatientdata(patientId);
//    }

    @PostMapping("/createbooking")
    public BookingResponse createBooking(@RequestBody RequestForBooking requestForBooking){
        return bookingInterface.createBooking(requestForBooking);
    }

    @GetMapping("/doctor/getAllAppointmentsForDoctor/{doctorId}")
    public List<Booking> getAllAppointmentsForDoctor(@PathVariable String doctorId){
        logger.info("inside controller for getAllAppointmentsForDoctor");
        return bookingInterface.getAllAppointmentsForDoctor(doctorId);
    }

    @GetMapping("/patient/appointments/{patientId}")
    public List<Booking> getAllAppointmentsForPatient(@PathVariable String patientId){
        logger.info("inside controller for getAllAppointmentsForPatient");
        return bookingInterface.getAllAppointmentsForPatient(patientId);
    }
}
