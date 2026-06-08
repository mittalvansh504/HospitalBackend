package com.example.HealthManagement.Doctor.Controller;


import com.example.HealthManagement.Doctor.Entities.Degree;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Doctor.Entities.DoctorDto;
import com.example.HealthManagement.Doctor.Repository.DoctorRepository;
import com.example.HealthManagement.Doctor.Requests.RequestForDoctor;
import com.example.HealthManagement.Doctor.Requests.RequestForLogin;
import com.example.HealthManagement.Doctor.Interface.DoctorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorInterface doctorInterface;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/addDegree")
    public Degree addDegree(@RequestBody Degree degree){
        return doctorInterface.addDegree(degree);
    }

    @GetMapping("/allDegree")
    public List<Degree> allDegree(){
        return doctorInterface.allDegree();
    }

    @PostMapping("/postDoctor")
    public Doctor postDoctor(@RequestBody RequestForDoctor requestForDoctor){
        return doctorInterface.postDoctor(requestForDoctor);
    }

    @PostMapping("/loginDoctor")
    public DoctorDto loginDoctor(@RequestBody RequestForLogin requestForLogin){
        return doctorInterface.loginDoctor(requestForLogin);
    }

    @GetMapping("/getDoctorByDoctorId/{doctorId}")
    public Doctor getDoctorByDoctorId(@PathVariable String doctorId){
        return doctorInterface.getDoctorByDoctorId(doctorId);
    }

    @PutMapping("/updateDoctorData/{doctorId}")
    public Doctor updateDoctorData(@PathVariable String doctorId, @RequestBody RequestForDoctor requestForDoctor){
        return doctorInterface.updateDoctorData(doctorId, requestForDoctor);
    }


}
