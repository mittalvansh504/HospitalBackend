package com.example.HealthManagement.Doctor.Entities;

import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Appointment.Entities.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String doctorName;
    private String doctorEmail;
    private String phoneNo;
    private LocalDate doctorDob;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Booking> bookings;

    private String degree;

    @ManyToMany
    @JoinTable(
                name = "doctor_department",
                joinColumns=@JoinColumn(name = "doctor_id"),
                inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private Set<Department> departments;


    private String addressLine1;
    private String addressLine2;
    private String password;
    @Transient
    private String confirmPassword;
}
