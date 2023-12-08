package com.employeeManagementSystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagementSystem.entities.Employee;
import com.employeeManagementSystem.payload.EmployeeDto;
import com.employeeManagementSystem.repositories.EmployeeRepo;
import com.employeeManagementSystem.service.EmployeeService;
import com.employeeManagementSystem.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = this.dtoToEmployee(employeeDto);
		Employee savedEmployee = this.employeeRepo.save(employee);
		return this.employeeToDto(savedEmployee);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId) {
		Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee","Id",employeeId));
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPassword(employeeDto.getPassword());
		employee.setAbout(employeeDto.getAbout());
		
		Employee updatedEmployee = this.employeeRepo.save(employee);
		EmployeeDto employeeDto1 = this.employeeToDto(updatedEmployee);
		return employeeDto1;
	}

	@Override
	public EmployeeDto getEmployeeById(Integer employeeId) {
		Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",employeeId));		
		return this.employeeToDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = this.employeeRepo.findAll();
		List<EmployeeDto> employeeDtos = employees.stream().map(employee -> this.employeeToDto(employee)).collect(Collectors.toList());		
		return employeeDtos;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
	Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",employeeId));
	 this.employeeRepo.delete(employee);
	}
	
	public Employee dtoToEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setAbout(employeeDto.getAbout());
		employee.setPassword(employeeDto.getPassword());
		return employee;
	}
	
	public EmployeeDto employeeToDto(Employee employee) {
		 EmployeeDto  employeeToDto = new EmployeeDto();
		 employeeToDto.setId(employee.getId());
		 employeeToDto.setName(employee.getName());
		 employeeToDto.setEmail(employee.getEmail());
		 employeeToDto.setAbout(employee.getAbout());
		 employeeToDto.setPassword(employee.getPassword());
		 return employeeToDto;
	}

}
