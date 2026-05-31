package com.example.HealthManagement.Appointment.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestForBooking {

    private String patientId;
//    private String relation;
//    private String patientName;
//    private LocalDate patientDob;
//    private String patientPhone;
//    private String patientAddress;

    private String departmentId;
    private String doctorId;

    private String disease;
    private LocalDate appointmentDate;
}
