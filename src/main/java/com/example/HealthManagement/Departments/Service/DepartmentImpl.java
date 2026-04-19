package com.example.HealthManagement.Departments.Service;

import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Departments.Interface.DepartmentInterface;
import com.example.HealthManagement.Departments.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentImpl implements DepartmentInterface {

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
