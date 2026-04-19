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
    public Patient addpatient(RequestForPatient requestForPatient) throws Exception {
        if (patientRepository.existsByEmail(requestForPatient.getEmail()) != null) {
            throw new RuntimeException("Patient already exists with this email");
        }

        if (patientRepository.existsByPhoneno(requestForPatient.getPhoneNo()) != null) {
            throw new RuntimeException("Patient already exists with this phone number");
        }
        Patient patient = new Patient();
        patient.setFirstName(requestForPatient.getFirstName());
        patient.setLastName(requestForPatient.getLastName());
        patient.setEmail(requestForPatient.getEmail());
        patient.setPhoneNo(requestForPatient.getPhoneNo());
        patient.setDob(requestForPatient.getDob());
        patient.setAddressLine1(requestForPatient.getAddressLine1());
        patient.setAddressLine2(requestForPatient.getAddressLine2());

        String encodedPassword = passwordEncoder.encode(requestForPatient.getPassword());
        patient.setPassword(encodedPassword);

        patientRepository.save(patient);
        return patient;
    }

    @Override
    public Patient getpatientbyname(String patientName) {
        return patientRepository.getpatientbyname(patientName);
    }

    @Override
    public Patient loginpatient(RequestForPatientLogin requestForPatientLogin) {
        Patient patient = patientRepository.findByEmail(requestForPatientLogin.getEmail().trim())
                .orElseThrow(() -> new RuntimeException("Invalid Email or Password"));

        if (!passwordEncoder.matches(requestForPatientLogin.getPassword().trim(), patient.getPassword())) {
            throw new RuntimeException("Invalid Email or Password");
        }

        return patient;

    }

    @Override
    public Patient getpatient(String email_id) {
        return patientRepository.getpatient(email_id);
    }
}
