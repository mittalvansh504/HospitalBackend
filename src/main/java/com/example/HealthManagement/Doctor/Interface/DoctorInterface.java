package com.example.HealthManagement.Doctor.Interface;


import com.example.HealthManagement.Doctor.Entities.Degree;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Doctor.Entities.DoctorDto;
import com.example.HealthManagement.Doctor.Requests.RequestForDoctor;
import com.example.HealthManagement.Doctor.Requests.RequestForLogin;

import javax.print.Doc;
import java.util.List;

public interface DoctorInterface {

    Degree adddegree(Degree degree);

    List<Degree> alldegree();

    Doctor postdoctor(RequestForDoctor requestForDoctor);

    DoctorDto logindoctor(RequestForLogin requestForLogin);

    Doctor getdoctorbydoctorid(String doctorId);

    Doctor updatedoctordata(String doctorId, RequestForDoctor requestForDoctor);
}
