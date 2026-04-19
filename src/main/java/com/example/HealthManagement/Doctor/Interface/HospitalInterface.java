package com.example.HealthManagement.Doctor.Interface;


import com.example.HealthManagement.Doctor.Entities.NewHospital;
import com.example.HealthManagement.Doctor.Requests.RequestForHospital;

public interface HospitalInterface {
    void addhospital(RequestForHospital requestForHospital);

    NewHospital hospitalbynameget(String hospitalname);
}
