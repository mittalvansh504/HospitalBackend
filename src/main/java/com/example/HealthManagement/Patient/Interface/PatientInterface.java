package com.example.HealthManagement.Patient.Interface;


import com.example.HealthManagement.Patient.Entities.Patient;
import com.example.HealthManagement.Patient.Request.RequestForPatient;
import com.example.HealthManagement.Patient.Request.RequestForPatientLogin;

public interface PatientInterface {
    Patient addpatient(RequestForPatient requestForPatient) throws Exception;
    Patient getpatientbyname(String patientName);

    Patient loginpatient(RequestForPatientLogin requestForPatientLogin);
    Patient getpatient(String email_id);
}
