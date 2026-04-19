package com.example.HealthManagement.Appointment.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorHistory {
    private String bookingId;
    private String patientName;
    private String patientPhone;
    private String disease;
    private LocalDate appointmentDate;

}
