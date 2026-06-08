package com.example.HealthManagement.Patient.Interface;


import com.example.HealthManagement.Patient.Entities.Patient;
import com.example.HealthManagement.Patient.Request.RequestForPatient;
import com.example.HealthManagement.Patient.Request.RequestForPatientLogin;

public interface PatientInterface {
    Patient addPatient(RequestForPatient requestForPatient) throws Exception;

    Patient loginPatient(RequestForPatientLogin requestForPatientLogin);

    Patient getPatientByPatientId(String patientId);

    Patient getpatient(String email_id);

    Patient updatePatientByPatientId(String patientId, RequestForPatient requestForPatient);
}
