package com.example.HealthManagement.Appointment.Service;

import com.example.HealthManagement.Appointment.Entities.AppointmentStatus;
import com.example.HealthManagement.Appointment.Entities.BookingHistoryResponse;
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

import java.time.LocalDate;
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

        Patient patientByDb = patientRepository.findByPatientId(requestForBooking.getPatientId());
        if(patientByDb == null){
            throw new RuntimeException("Patient is not exist");
        }

        Department departmentByDb = departmentRepository.findByDepartmentId(requestForBooking.getDepartmentId());
        if (departmentByDb == null) {
            throw new RuntimeException("Department is not exist with this department name");
        }

        Doctor doctorByDb = doctorRepository.findByDoctorId(requestForBooking.getDoctorId());
        if (doctorByDb == null) {
            throw new RuntimeException("Doctor does not exist");
        }

        Booking booking = new Booking();
        booking.setPatientId(requestForBooking.getPatientId());
        booking.setDepartmentId(requestForBooking.getDepartmentId());
        booking.setDoctorId(requestForBooking.getDoctorId());
        booking.setDisease(requestForBooking.getDisease());
        booking.setAppointmentDate(requestForBooking.getAppointmentDate());
        if(booking.getAppointmentDate().isBefore(LocalDate.now())){
            booking.setStatus(AppointmentStatus.NOT_VISITED);
        }
        else{
            booking.setStatus(AppointmentStatus.BOOKED);
        }
        Booking savedBooking = bookingRepository.save(booking);
        return new BookingResponse(
                savedBooking.getBookingId(),
                patientByDb.getPatientName(),
                patientByDb.getPatientDOB(),
                patientByDb.getPhoneNo(),
                patientByDb.getPermanentAddress(),
                doctorByDb.getDoctorName(),
                savedBooking.getDisease(),
                savedBooking.getAppointmentDate(),
                savedBooking.getStatus()
        );
    }

    @Override
    public List<BookingHistoryResponse> getAllAppointmentsForDoctor(String doctorId){

        List<Booking> bookings = bookingRepository.findByDoctorId(doctorId);

        if (bookings == null || bookings.isEmpty()) {
            throw new RuntimeException("There is no booking exist for this Doctor");
        }

        return bookings.stream().map(booking -> {
            Patient patient = patientRepository.findByPatientId(booking.getPatientId());

            Doctor doctor = doctorRepository.findByDoctorId(booking.getDoctorId());

            return new BookingHistoryResponse(
                    booking.getBookingId(),
                    patient.getPatientName(),
                    doctor.getDoctorName(),
                    doctor.getPhoneNo(),
                    patient.getPhoneNo(),
                    booking.getDisease(),
                    booking.getAppointmentDate(),
                    booking.getStatus()
            );
        }).toList();
    }

    @Override
    public List<BookingHistoryResponse> getAllAppointmentsForPatient(String patientId) {

        List<Booking> bookings = bookingRepository.findByPatientId(patientId);

        if (bookings == null || bookings.isEmpty()) {
            throw new RuntimeException("There is no booking exist for this patient");
        }

        return bookings.stream().map(booking -> {
            Patient patient = patientRepository.findByPatientId(booking.getPatientId());

            Doctor doctor = doctorRepository.findByDoctorId(booking.getDoctorId());

            return new BookingHistoryResponse(
                    booking.getBookingId(),
                    patient.getPatientName(),
                    doctor.getDoctorName(),
                    doctor.getPhoneNo(),
                    patient.getPhoneNo(),
                    booking.getDisease(),
                    booking.getAppointmentDate(),
                    booking.getStatus()
            );
        }).toList();
    }

    @Override
    public String markVisited(String bookingId){
        Booking booking = bookingRepository.findByBookingId(bookingId);

        if(booking == null){
            throw new RuntimeException("Booking not found");
        }
        booking.setStatus(AppointmentStatus.VISITED);
        bookingRepository.save(booking);
        return "Patient marked as visited";
    }

}