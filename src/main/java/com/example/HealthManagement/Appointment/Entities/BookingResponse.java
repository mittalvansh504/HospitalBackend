package com.example.HealthManagement.Appointment.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private String bookingId;
    private String patientName;
    private String doctorName;
    private String disease;
    private LocalDate appointmentDate;
}
