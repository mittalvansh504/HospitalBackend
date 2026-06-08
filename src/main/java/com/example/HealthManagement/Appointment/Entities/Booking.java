package com.example.HealthManagement.Appointment.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bookings")
public class Booking {

    @Id
    private String bookingId;
    private String slotNo = "SLOT-" + UUID.randomUUID().toString().substring(0,5);

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
    private AppointmentStatus status;

    private LocalDate createdOn = LocalDate.now();
    private boolean active = true;
}
