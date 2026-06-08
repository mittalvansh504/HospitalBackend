package com.example.HealthManagement.Departments.Interface;

import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Doctor.Entities.Doctor;

import java.util.List;

public interface DepartmentInterface {

    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentByDepartmentId(String departmentId);

    Department getDepartmentByDepartmentName(String departmentName);

    List<Doctor> getDoctorByDepartmentId(String departmentId);
}
