package com.example.HealthManagement.Departments.Service;

import com.example.HealthManagement.Departments.Entity.Department;
import com.example.HealthManagement.Departments.Interface.DepartmentInterface;
import com.example.HealthManagement.Departments.Repository.DepartmentRepository;
import com.example.HealthManagement.Doctor.Entities.Doctor;
import com.example.HealthManagement.Doctor.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentImpl implements DepartmentInterface {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentByDepartmentId(String departmentId) {
        Optional<Department> dFromDb = departmentRepository.findById(departmentId);
        if(dFromDb.isEmpty()){
            return null;
        }

        return dFromDb.get();
    }

    @Override
    public Department getDepartmentByDepartmentName(String departmentName) {
        Department dFromDb = departmentRepository.findByDeptName(departmentName);
        if(dFromDb == null){
            return null;
        }

        return dFromDb;
    }

    @Override
    public List<Doctor> getDoctorByDepartmentId(String departmentId) {
        List<Doctor> doctors = doctorRepository.findByDepartmentId(departmentId);

        if(doctors.isEmpty()){
            throw new RuntimeException("No doctors found for this department");
        }

        return doctors;
    }
}
