package com.example.HealthManagement.Doctor.Interface;


import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Doctor.Entities.DoctorDto;
import com.example.HealthManagement.Doctor.Requests.RequestForDoctor;
import com.example.HealthManagement.Doctor.Requests.RequestForLogin;

import java.util.List;

public interface DoctorInterface {


    Doctor postdoctor(RequestForDoctor requestForDoctor);

    DoctorDto logindoctor(RequestForLogin requestForLogin);

    List<DoctorDto> getDoctorsByDepartment(Long deptId);

}
