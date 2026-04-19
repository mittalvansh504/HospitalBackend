package com.example.HealthManagement.Departments.Interface;

import com.example.HealthManagement.Departments.Entity.Department;

import java.util.List;

public interface DepartmentInterface {
    List<Department> getAllDepartments();

    Department saveDepartment(Department department);
}
