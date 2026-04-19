package com.example.HealthManagement.Departments.Controller;

import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Departments.Interface.DepartmentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentInterface departmentInterface;

    @PostMapping("/postingdepartment")
    private Department createDepartment(@RequestBody Department department){
        return departmentInterface.saveDepartment(department);
    }


    @GetMapping("/getalldepartment")
    public List<Department> getDepartments(){
        return departmentInterface.getAllDepartments();
    }
}
