package com.employeeManagementSystem.service;

import java.util.List;

import com.employeeManagementSystem.payload.EmployeeDto;

public interface EmployeeService {
    
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId);
	EmployeeDto getEmployeeById(Integer employeeId);
	List<EmployeeDto> getAllEmployees();
	void deleteEmployee(Integer employeeId);
}
