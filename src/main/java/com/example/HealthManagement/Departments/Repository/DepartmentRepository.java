package com.example.HealthManagement.Departments.Repository;

import com.example.HealthManagement.Departments.Entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface DepartmentRepository extends MongoRepository<Department, String> {

    @Query("{deptName:'?0'}")
    Department findByDeptName(String deptName);

    @Query("{departmentId:?0}")
    Department findByDepartmentId(String departmentId);
}