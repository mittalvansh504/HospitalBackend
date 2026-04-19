package com.example.HealthManagement.Doctor.Controller;


import com.example.HealthManagement.Doctor.Entities.NewHospital;
import com.example.HealthManagement.Doctor.Requests.RequestForHospital;
import com.example.HealthManagement.Doctor.Interface.HospitalInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Hospital")
public class HospitalController {

    @Autowired
    private HospitalInterface hospitalInterface;

    @PostMapping("/hospitaldetail")
    public String hospitaldata(@RequestBody RequestForHospital requestForHospital){
        hospitalInterface.addhospital(requestForHospital);
        return "Done";
    }

    @GetMapping("/gethospitalbyname/{hospitalname}")
    public NewHospital hospitalbyname(@PathVariable String hospitalname){
        return hospitalInterface.hospitalbynameget(hospitalname);
    }
}
