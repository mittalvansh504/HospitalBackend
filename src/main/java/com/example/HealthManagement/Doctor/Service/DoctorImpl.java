package com.example.HealthManagement.Doctor.Service;

import com.example.HealthManagement.Appointment.Entities.AppointmentStatus;
import com.example.HealthManagement.Appointment.Entities.Booking;
import com.example.HealthManagement.Appointment.Repository.BookingRepository;
import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Departments.Repository.DepartmentRepository;
import com.example.HealthManagement.Doctor.Entities.Degree;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Doctor.Entities.DoctorDto;
import com.example.HealthManagement.Doctor.Repository.DegreeRepository;
import com.example.HealthManagement.Doctor.Repository.DoctorRepository;
import com.example.HealthManagement.Doctor.Requests.RequestForDoctor;
import com.example.HealthManagement.Doctor.Requests.RequestForLogin;
import com.example.HealthManagement.Doctor.Interface.DoctorInterface;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorImpl implements DoctorInterface {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Degree addDegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    @Override
    public List<Degree> allDegree() {
        return degreeRepository.findAll();
    }

    @Override
    public Doctor postDoctor(RequestForDoctor requestForDoctor) {

        if (!requestForDoctor.getPassword().equals(requestForDoctor.getConfirmPassword())) {
            throw new RuntimeException("Password Do not Match");
        }

        if (doctorRepository.existsByDoctorEmail(requestForDoctor.getDoctorEmail())) {
            throw new RuntimeException("Doctor already exists with this email");
        }

        if (doctorRepository.existsByPhoneNo(requestForDoctor.getPhoneNo())) {
            throw new RuntimeException("Doctor already exists with this phone number");
        }

        Degree degreeInDbById = degreeRepository.findByDegreeId(requestForDoctor.getDegreeId());
        if(degreeInDbById == null){
            throw new RuntimeException("Degree does not exist in database");
        }

        Department departmentInDbById = departmentRepository.findByDepartmentId(requestForDoctor.getDepartmentId());

        if(departmentInDbById == null){
            throw new RuntimeException("Provided Department does not exist in database");
        }

        Doctor doctor = new Doctor();

        doctor.setDoctorName(requestForDoctor.getDoctorName());
        doctor.setDoctorEmail(requestForDoctor.getDoctorEmail());
        doctor.setPhoneNo(requestForDoctor.getPhoneNo());
        doctor.setDoctorDob(requestForDoctor.getDoctorDob());
        doctor.setDegreeId(degreeInDbById.getDegreeName());
        doctor.setExperience(requestForDoctor.getExperience());
        doctor.setDepartmentId(departmentInDbById.getDepartmentId());
        doctor.setAddressLine1(requestForDoctor.getAddressLine1());
        doctor.setAddressLine2(requestForDoctor.getAddressLine2());

        String encodedPassword = passwordEncoder.encode(requestForDoctor.getPassword()) ;
        doctor.setPassword(encodedPassword);

        doctorRepository.save(doctor);

        return doctor;
    }

    @Override
    public DoctorDto loginDoctor(RequestForLogin requestForLogin) {

        Doctor doctor = doctorRepository.findByDoctorEmail(requestForLogin.getDoctorEmail().trim())
                .orElseThrow(() -> new RuntimeException("Invalid Email or Password"));

        if (!passwordEncoder.matches(requestForLogin.getPassword().trim(), doctor.getPassword())) {
            throw new RuntimeException("Invalid Email or Password");
        }

        return new DoctorDto(
                doctor.getDoctorId(),
                doctor.getDoctorName()
        );
    }

    @Override
    public Doctor getDoctorByDoctorId(String doctorId) {
        Doctor doctor = doctorRepository.findByDoctorId(doctorId);
        return doctor;
    }

    @Override
    public Doctor updateDoctorData(String doctorId, RequestForDoctor requestForDoctor) {
        Doctor existingDoctor = doctorRepository.findByDoctorId(doctorId);
        if(existingDoctor == null){
            throw new RuntimeException("Doctor Not exist");
        }

        Degree degreeInDBByName = degreeRepository.findByDegreeId(requestForDoctor.getDegreeId());
        if(degreeInDBByName.getDegreeName() == null || degreeInDBByName.getDegreeId().isEmpty()){
            throw new RuntimeException("Degree is not exist in our database");
        }

        Department departmentInDbByName = departmentRepository.findByDepartmentId(requestForDoctor.getDepartmentId());
        if(departmentInDbByName.getDeptName() == null || departmentInDbByName.getDepartmentId().isEmpty()){
            throw new RuntimeException("Provided DepartmentName does not exist in database");
        }

        existingDoctor.setDegreeId(degreeInDBByName.getDegreeName());
        existingDoctor.setExperience(requestForDoctor.getExperience());
        existingDoctor.setDepartmentId(departmentInDbByName.getDeptName());
        existingDoctor.setAddressLine1(requestForDoctor.getAddressLine1());
        existingDoctor.setAddressLine2(requestForDoctor.getAddressLine2());

        return doctorRepository.save(existingDoctor);
    }
}
