package com.example.HealthManagement.Appointment.Entities;

import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Patient.Entities.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotNo;

    @Column(unique = true, nullable = false)
    private String bookingId;

    private String patientName;
    private LocalDate patientDob;
    private String patientPhone;
    private String patientAddress;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;


    private String disease;
    private LocalDate appointmentDate;

    @PrePersist
    public void generateValues() {
        if (this.bookingId == null) {
            this.bookingId = UUID.randomUUID().toString();
        }
    }
}
