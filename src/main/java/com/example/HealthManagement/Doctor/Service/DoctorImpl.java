package com.example.HealthManagement.Doctor.Service;

import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Departments.Repository.DepartmentRepository;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Doctor.Entities.DoctorDto;
import com.example.HealthManagement.Doctor.Repository.DoctorRepository;
import com.example.HealthManagement.Doctor.Requests.RequestForDoctor;
import com.example.HealthManagement.Doctor.Requests.RequestForLogin;
import com.example.HealthManagement.Doctor.Interface.DoctorInterface;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class DoctorImpl implements DoctorInterface {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        Set<Department> departments = new HashSet<>();

        for (String deptName : requestForDoctor.getDepartmentNames()) {

            Department department = departmentRepository
                    .findByDeptName(deptName)
                    .orElseThrow(() -> new RuntimeException("Department not found: " + deptName));

            departments.add(department);
        }

        Doctor doctor = new Doctor();
        doctor.setDoctorName(requestForDoctor.getDoctorName());
        doctor.setDoctorEmail(requestForDoctor.getDoctorEmail());
        doctor.setPhoneNo(requestForDoctor.getPhoneNo());
        doctor.setDoctorDob(requestForDoctor.getDoctorDob());
        doctor.setDegree(requestForDoctor.getDegree());
        doctor.setDepartments(departments);
        doctor.setAddressLine1(requestForDoctor.getAddressLine1());
        doctor.setAddressLine2(requestForDoctor.getAddressLine2());

        String encodedPassword = passwordEncoder.encode(requestForDoctor.getPassword());
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
    public List<DoctorDto> getDoctorsByDepartment(Long deptId) {
        List<Doctor> doctors = doctorRepository.findByDepartmentsDepartmentId(deptId);

        return doctors.stream()
                .map(doc -> new DoctorDto(
                        doc.getDoctorId(),
                        doc.getDoctorName()
                ))
                .toList();
    }

}
