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

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody RequestForPatient requestForPatient) throws Exception {
        return patientInterface.addPatient(requestForPatient);
    }

    @PostMapping("/loginPatient")
    public Patient loginPatient(@RequestBody RequestForPatientLogin requestForPatientLogin){
        return patientInterface.loginPatient(requestForPatientLogin);
    }

    @GetMapping("/getPatientByPatientId/{patientId}")
    public Patient getPatientByPatientId(@PathVariable String patientId){
        return patientInterface.getPatientByPatientId(patientId);
    }

    @PutMapping("/updatePatientByPatientId/{patientId}")
    public Patient updatepatientbypatientid(@PathVariable String patientId, @RequestBody RequestForPatient requestForPatient){
        return patientInterface.updatePatientByPatientId(patientId, requestForPatient);
    }

}
