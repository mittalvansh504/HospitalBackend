package com.example.HealthManagement.Appointment.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestForBooking {

    private String patientName;
    private LocalDate patientDob;
    private String patientPhone;
    private String patientAddress;

    private Long departmentId;
    private Long doctorId;
    private Long patientId;

    private String disease;
    private LocalDate appointmentDate;
}
