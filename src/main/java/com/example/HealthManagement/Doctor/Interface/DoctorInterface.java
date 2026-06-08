package com.example.HealthManagement.Doctor.Interface;


import com.example.HealthManagement.Doctor.Entities.Degree;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Doctor.Entities.DoctorDto;
import com.example.HealthManagement.Doctor.Requests.RequestForDoctor;
import com.example.HealthManagement.Doctor.Requests.RequestForLogin;

import javax.print.Doc;
import java.util.List;

public interface DoctorInterface {

    Degree addDegree(Degree degree);

    List<Degree> allDegree();

    Doctor postDoctor(RequestForDoctor requestForDoctor);

    DoctorDto loginDoctor(RequestForLogin requestForLogin);

    Doctor getDoctorByDoctorId(String doctorId);

    Doctor updateDoctorData(String doctorId, RequestForDoctor requestForDoctor);

}
