package com.example.HealthManagement.Doctor.Service;

import com.example.HealthManagement.Doctor.Entities.NewHospital;
import com.example.HealthManagement.Doctor.Repository.HospitalRepository;
import com.example.HealthManagement.Doctor.Requests.RequestForHospital;
import com.example.HealthManagement.Doctor.Interface.HospitalInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalImpl implements HospitalInterface {

    @Autowired
    private HospitalRepository hospitalRepository;


    @Override
    public void addhospital(RequestForHospital requestForHospital) {
        NewHospital hospital = new NewHospital();
        hospital.setHospitalName(requestForHospital.getHospitalName());
        hospital.setHospitalName(requestForHospital.getHospitalName());
        hospitalRepository.save(hospital);
    }

    @Override
    public NewHospital hospitalbynameget(String hospitalname) {
         return hospitalRepository.hospitalbynameget(hospitalname);
    }

}
