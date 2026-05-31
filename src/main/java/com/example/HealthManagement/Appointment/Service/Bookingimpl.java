package com.example.HealthManagement.Appointment.Service;

import com.example.HealthManagement.Appointment.Interface.BookingInterface;
import com.example.HealthManagement.Appointment.Repository.BookingRepository;
import com.example.HealthManagement.Appointment.Entities.Booking;
import com.example.HealthManagement.Appointment.Entities.BookingResponse;
import com.example.HealthManagement.Appointment.Request.RequestForBooking;
import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Departments.Repository.DepartmentRepository;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Doctor.Repository.DoctorRepository;
import com.example.HealthManagement.Patient.Entities.Patient;
import com.example.HealthManagement.Patient.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
public class Bookingimpl implements BookingInterface {

    private static final Logger logger = Logger.getLogger(String.valueOf(Bookingimpl.class));

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    @Override
    public BookingResponse createBooking(RequestForBooking requestForBooking) {

        Department departmentByDb = departmentRepository.findByDepartmentId(requestForBooking.getDepartmentId());
        if (departmentByDb == null) {
            throw new RuntimeException("Department is not exist with this department name");
        }

        Doctor doctorByDb = doctorRepository.findByDoctorId(requestForBooking.getDoctorId());
        if (doctorByDb == null) {
            throw new RuntimeException("Doctor does not exist");
        }

        Patient patientByDb = patientRepository.findByPatientId(requestForBooking.getPatientId());
        if(patientByDb == null){
            throw new RuntimeException("Patient is not exist");
        }
        Booking booking = new Booking();
        booking.setDepartmentId(requestForBooking.getDepartmentId());
        booking.setDoctorId(requestForBooking.getDoctorId());
        booking.setDisease(requestForBooking.getDisease());
        booking.setAppointmentDate(requestForBooking.getAppointmentDate());
        Booking savedBooking = bookingRepository.save(booking);
        return new BookingResponse(
                savedBooking.getBookingId(),
                patientByDb.getPatientName(),
                patientByDb.getPatientDOB(),
                patientByDb.getPhoneNo(),
                patientByDb.getPermanentAddress(),
                doctorByDb.getDoctorName(),
                savedBooking.getDisease(),
                savedBooking.getAppointmentDate()
        );
    }

    @Override
    public List<Booking> getAllAppointmentsForDoctor(String doctorId){

        List<Booking> bookings = bookingRepository.findByDoctorId(doctorId);

        if(bookings == null){
            throw new RuntimeException("There is no booking exist for this doctor");
        }
        logger.info("Inside booking implementation for getting all appointments for a doctor");
        return bookings;
    }

    @Override
    public List<Booking> getAllAppointmentsForPatient(String patientId) {
        List<Booking> bookings = bookingRepository.findByPatientId(patientId);

        if (bookings == null) {
            throw new RuntimeException("There is no booking exist for this patient");
        }
        logger.info("Inside booking implementation for getting all appointments for a patient");

        return bookings;
    }

}