package com.employeeManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagementSystem.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
          
}
