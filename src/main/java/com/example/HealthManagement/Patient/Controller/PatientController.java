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

    @PostMapping("/loginpatient")
    public Patient loginpatient(@RequestBody RequestForPatientLogin requestForPatientLogin){
        return patientInterface.loginpatient(requestForPatientLogin);
    }

    @GetMapping("/getpatientbypatientid/{patientId}")
    public Patient getpatientbypatientid(@PathVariable String patientId){
        return patientInterface.getpatientbypatientid(patientId);
    }

    @PutMapping("/updatepatientbypatientid/{patientId}")
    public Patient updatepatientbypatientid(@PathVariable String patientId, @RequestBody RequestForPatient requestForPatient){
        return patientInterface.updatepatientbypatientid(patientId, requestForPatient);
    }

}
