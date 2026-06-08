package com.example.HealthManagement.Departments.Controller;

import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Departments.Interface.DepartmentInterface;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentInterface departmentInterface;

    @PostMapping("/createDepartment")
    private Department createDepartment(@RequestBody Department department){
        return departmentInterface.createDepartment(department);
    }

    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartments(){
        return departmentInterface.getAllDepartments();
    }

    @GetMapping("/getDepartmentByDepartmentId/{departmentId}")
    public Department getDepartmentByDepartmentId(@PathVariable String departmentId){
        return departmentInterface.getDepartmentByDepartmentId(departmentId);
    }

    @GetMapping("/getDepartmentByDepartmentName/{departmentName}")
    public Department getDepartmentByDepartmentName(@PathVariable String departmentName){
        return departmentInterface.getDepartmentByDepartmentName(departmentName);
    }

    @GetMapping("/getDoctorByDepartmentId/{departmentId}")
    public List<Doctor> getDoctorByDepartmentId(@PathVariable String departmentId){
        return departmentInterface.getDoctorByDepartmentId(departmentId);
    }
}
