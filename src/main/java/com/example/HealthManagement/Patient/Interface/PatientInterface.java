package com.example.HealthManagement.Patient.Interface;


import com.example.HealthManagement.Patient.Entities.Patient;
import com.example.HealthManagement.Patient.Request.RequestForPatient;
import com.example.HealthManagement.Patient.Request.RequestForPatientLogin;

public interface PatientInterface {
    Patient addpatient(RequestForPatient requestForPatient) throws Exception;

    Patient loginpatient(RequestForPatientLogin requestForPatientLogin);

    Patient getpatientbypatientid(String patientId);

    Patient getpatient(String email_id);

    Patient updatepatientbypatientid(String patientId, RequestForPatient requestForPatient);
}
