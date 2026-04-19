package com.example.HealthManagement.Appointment.Service;

import com.example.HealthManagement.Appointment.Interface.BookingInterface;
import com.example.HealthManagement.Appointment.Repository.BookingRepository;
import com.example.HealthManagement.Appointment.Entities.Booking;
import com.example.HealthManagement.Appointment.Entities.BookingResponse;
import com.example.HealthManagement.Appointment.Request.DoctorHistory;
import com.example.HealthManagement.Appointment.Request.PatientHistoryData;
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

@Service
public class Bookingimpl implements BookingInterface {

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
    public BookingResponse bookingpatient(RequestForBooking requestForBooking) {

            Department department = departmentRepository
                    .findById(requestForBooking.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department Not Found"));

            Doctor doctor = doctorRepository
                    .findById(requestForBooking.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor not Found"));

            Patient patient = patientRepository
                    .findById(requestForBooking.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));

            boolean exists = doctorRepository.existsByDoctorIdAndDepartmentsDepartmentId(
                    requestForBooking.getDoctorId(),
                    requestForBooking.getDepartmentId()
            );

            if (!exists) {
                throw new RuntimeException("Doctor does not belong to selected department");
            }


            Booking booking = new Booking();

            booking.setPatientName(requestForBooking.getPatientName());
            booking.setPatientDob(requestForBooking.getPatientDob());
            booking.setPatientPhone(requestForBooking.getPatientPhone());
            booking.setPatientAddress(requestForBooking.getPatientAddress());

            booking.setDoctor(doctor);
            booking.setDepartment(department);
            booking.setPatient(patient);

            booking.setDisease(requestForBooking.getDisease());
            booking.setAppointmentDate(requestForBooking.getAppointmentDate());

            Booking savedBooking = bookingRepository.save(booking);


            return new BookingResponse(
                    savedBooking.getBookingId(),
                    savedBooking.getPatientName(),
                    savedBooking.getDoctor().getDoctorName(),
                    savedBooking.getDisease(),
                    savedBooking.getAppointmentDate());
    }

    @Override
    public List<DoctorHistory> getallpatient(Long doctorId){

        List<Booking> bookings = bookingRepository.findByDoctorDoctorId(doctorId);

        List<DoctorHistory> list = bookings.stream()
                .map(b -> new DoctorHistory(
                        b.getBookingId(),
                        b.getPatientName(),
                        b.getPatientPhone(),
                        b.getDisease(),
                        b.getAppointmentDate()
                ))
                .toList();
        return list;
    }

    @Override
    public List<PatientHistoryData> getalldoctor(Long patientId){
        List<Booking> bookings = bookingRepository.findByPatientPatientId(patientId);

        List<PatientHistoryData> list = bookings.stream().
                map(b -> new PatientHistoryData(
                        b.getBookingId(),
                        b.getPatientName(),
                        b.getDoctor().getDoctorName(),
                        b.getDoctor().getPhoneNo(),
                        b.getAppointmentDate()
                )).toList();

        return list;
    }
}