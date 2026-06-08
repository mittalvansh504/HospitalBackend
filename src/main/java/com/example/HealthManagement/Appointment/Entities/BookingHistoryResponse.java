package com.example.HealthManagement.Appointment.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "historyResponse")
public class BookingHistoryResponse {

    private String bookingId;
    private String patientName;
    private String doctorName;
    private String doctorPhone;
    private String phoneNo;
    private String disease;
    private LocalDate appointmentDate;
    private AppointmentStatus status;
}
