package com.example.HealthManagement.Patient.Entities;

import com.example.HealthManagement.Appointment.Entities.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;

    @OneToMany(mappedBy = "patient")
    private List<Booking> bookings;

    private String phoneNo;
    private String addressLine1;
    private String addressLine2;
    private String password;

    @Transient
    private String confirmPassword;

}
