package com.example.HealthManagement.Patient.Controller;


import com.example.HealthManagement.Patient.Entities.Patient;
import com.example.HealthManagement.Patient.Request.RequestForPatient;
import com.example.HealthManagement.Patient.Request.RequestForPatientLogin;
import com.example.HealthManagement.Patient.Interface.PatientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientInterface patientInterface;

    @PostMapping("/signup")
    public Patient addpatient(@RequestBody RequestForPatient requestForPatient) throws Exception {
        return patientInterface.addpatient(requestForPatient);
    }

    @GetMapping("/getpatientbyname/{patientName}")
    public Patient getpatientbyname(@PathVariable String patientName){
        return patientInterface.getpatientbyname(patientName);
    }

    @PostMapping("/loginpatient")
    public Patient loginpatient(@RequestBody RequestForPatientLogin requestForPatientLogin){
        return patientInterface.loginpatient(requestForPatientLogin);
    }

    @GetMapping("/getpatientbyid/{email_id}")
    public Patient getpatient(@PathVariable String email_id){
        return patientInterface.getpatient(email_id);
    }
}
