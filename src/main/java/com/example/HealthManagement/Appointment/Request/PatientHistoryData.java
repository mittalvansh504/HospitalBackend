package com.example.HealthManagement.Appointment.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientHistoryData {

    private String bookingId;
    private String patientName;
    private String doctorName;
    private String doctorPhone;
    private LocalDate appointmentDate;
}
