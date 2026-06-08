package com.example.HealthManagement.Patient.Service;

import com.example.HealthManagement.Patient.Entities.Patient;
import com.example.HealthManagement.Patient.Repository.PatientRepository;
import com.example.HealthManagement.Patient.Request.RequestForPatient;
import com.example.HealthManagement.Patient.Request.RequestForPatientLogin;
import com.example.HealthManagement.Patient.Interface.PatientInterface;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PatientImpl implements PatientInterface {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Patient addPatient(RequestForPatient requestForPatient) throws Exception {
        if (patientRepository.existsByEmail(requestForPatient.getEmail()) != null) {
            throw new RuntimeException("Patient already exists with this email");
        }

        if (patientRepository.existsByPhoneno(requestForPatient.getPhoneNo()) != null) {
            throw new RuntimeException("Patient already exists with this phone number");
        }

        Patient patient = new Patient();
        patient.setPatientName(requestForPatient.getPatientName());
        patient.setEmail(requestForPatient.getEmail());
        patient.setPhoneNo(requestForPatient.getPhoneNo());
        patient.setPatientDOB(requestForPatient.getPatientDOB());
        patient.setFatherName(requestForPatient.getFatherName());
        patient.setMotherName(requestForPatient.getMotherName());
        patient.setPermanentAddress(requestForPatient.getPermanentAddress());
        patient.setCurrentAddress(requestForPatient.getCurrentAddress());

        String encodedPassword = passwordEncoder.encode(requestForPatient.getPassword());
        patient.setPassword(encodedPassword);

        patientRepository.save(patient);
        return patient;
    }

    @Override
    public Patient loginPatient(RequestForPatientLogin requestForPatientLogin) {
        Patient patient = patientRepository.findByEmail(requestForPatientLogin.getEmail().trim())
                .orElseThrow(() -> new RuntimeException("Invalid Email or Password"));

        if (!passwordEncoder.matches(requestForPatientLogin.getPassword().trim(), patient.getPassword())) {
            throw new RuntimeException("Invalid Email or Password");
        }
        return patient;
    }

    @Override
    public Patient getPatientByPatientId(String patientId) {
        Patient patient = patientRepository.findByPatientId(patientId);
        return patient;
    }

    @Override
    public Patient getpatient(String email_id) {
        return patientRepository.existsByEmail(email_id);
    }

    @Override
    public Patient updatePatientByPatientId(String patientId, RequestForPatient requestForPatient) {
        Patient patient = patientRepository.findByPatientId(patientId);

        if(patient == null){
            throw new RuntimeException("Patient is not exist with this Id");
        }
        patient.setCurrentAddress(requestForPatient.getCurrentAddress());
        return patientRepository.save(patient);
    }
}
