package com.example.HealthManagement.Departments.Interface;

import com.example.HealthManagement.Departments.Entity.Department;

import java.util.List;

public interface DepartmentInterface {

    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentNameById(String departmentId);

    Department getDepartmentByDepartmentName(String departmentName);
}
