package com.example.HealthManagement.Doctor.Service;

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


    @Override
    public Degree adddegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    @Override
    public List<Degree> alldegree() {
        return degreeRepository.findAll();
    }

    @Override
    public Doctor postdoctor(RequestForDoctor requestForDoctor) {

        if (!requestForDoctor.getPassword().equals(requestForDoctor.getConfirmPassword())) {
            throw new RuntimeException("Password Do not Match");
        }

        if (doctorRepository.existsByDoctorEmail(requestForDoctor.getDoctorEmail())) {
            throw new RuntimeException("Doctor already exists with this email");
        }

        if (doctorRepository.existsByPhoneNo(requestForDoctor.getPhoneNo())) {
            throw new RuntimeException("Doctor already exists with this phone number");
        }

        Department departmentInDbByName = departmentRepository.findByDeptName(requestForDoctor.getDepartmentName());
        if(departmentInDbByName.getDeptName() == null || departmentInDbByName.getDeptName().isEmpty()){
            throw new RuntimeException("Provided DepartmentName does not exist in database");
        }

        Degree degreeInDBByName = degreeRepository.findByDegreeName(requestForDoctor.getDegree());
        if(degreeInDBByName.getDegreeName() == null || degreeInDBByName.getDegreeName().isEmpty()){
            throw new RuntimeException("Degree is not exist in our database");
        }

        Doctor doctor = new Doctor();

        doctor.setDoctorName(requestForDoctor.getDoctorName());
        doctor.setDoctorEmail(requestForDoctor.getDoctorEmail());
        doctor.setPhoneNo(requestForDoctor.getPhoneNo());
        doctor.setDoctorDob(requestForDoctor.getDoctorDob());
        doctor.setDegree(requestForDoctor.getDegree());
        doctor.setExperience(requestForDoctor.getExperience());
        doctor.setDepartmentName(requestForDoctor.getDepartmentName());
        doctor.setAddressLine1(requestForDoctor.getAddressLine1());
        doctor.setAddressLine2(requestForDoctor.getAddressLine2());

        String encodedPassword = passwordEncoder.encode(requestForDoctor.getPassword()) ;
        doctor.setPassword(encodedPassword);

        doctorRepository.save(doctor);

        return doctor;
    }

    @Override
    public DoctorDto logindoctor(RequestForLogin requestForLogin) {

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
    public Doctor getdoctorbydoctorid(String doctorId) {
        Doctor doctor = doctorRepository.findByDoctorId(doctorId);
        return doctor;
    }

    @Override
    public Doctor updatedoctordata(String doctorId, RequestForDoctor requestForDoctor) {
        Doctor existingDoctor = doctorRepository.findByDoctorId(doctorId);
        if(existingDoctor == null){
            throw new RuntimeException("Doctor Not exist");
        }

        existingDoctor.setDegree(requestForDoctor.getDegree());
        existingDoctor.setExperience(requestForDoctor.getExperience());
        existingDoctor.setDepartmentName(requestForDoctor.getDepartmentName());
        existingDoctor.setAddressLine1(requestForDoctor.getAddressLine1());
        existingDoctor.setAddressLine2(requestForDoctor.getAddressLine2());

        return doctorRepository.save(existingDoctor);
    }

}
