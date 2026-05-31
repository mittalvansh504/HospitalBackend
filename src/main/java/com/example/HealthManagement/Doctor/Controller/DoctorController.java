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

    @PostMapping("/adddegree")
    public Degree adddegree(@RequestBody Degree degree){
        return doctorInterface.adddegree(degree);
    }

    @GetMapping("/alldegree")
    public List<Degree> alldegree(){
        return doctorInterface.alldegree();
    }

    @PostMapping("/registration")
    public Doctor postdoctor(@RequestBody RequestForDoctor requestForDoctor){
        return doctorInterface.postdoctor(requestForDoctor);
    }

    @PostMapping("/loginDoctor")
    public DoctorDto logindoctor(@RequestBody RequestForLogin requestForLogin){
        return doctorInterface.logindoctor(requestForLogin);
    }

    @GetMapping("/getdoctorbydoctorid/{doctorId}")
    public Doctor getdoctorbydoctorId(@PathVariable String doctorId){
        return doctorInterface.getdoctorbydoctorid(doctorId);
    }

    @PutMapping("/updatedoctordata/{doctorId}")
    public Doctor updatedoctordata(@PathVariable String doctorId, @RequestBody RequestForDoctor requestForDoctor){
        return doctorInterface.updatedoctordata(doctorId, requestForDoctor);
    }
}
