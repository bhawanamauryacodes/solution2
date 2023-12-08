package com.employeeManagementSystem.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employeeManagementSystem.entities.Employee;
import com.employeeManagementSystem.payload.ApiResponse;
import com.employeeManagementSystem.payload.EmployeeDto;
import com.employeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
   
	@Autowired
	private EmployeeService employeeService;
	
	// POST - create employee
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto createEmployeeDto = this.employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(createEmployeeDto, HttpStatus.CREATED);
	}
	
	// PUT - update employee
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("employeeId") Integer uid){
		EmployeeDto updateEmployee = this.employeeService.updateEmployee(employeeDto, uid);
		return ResponseEntity.ok(updateEmployee);
	}

	// DELETE - delete employee
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("employeeId") Integer uid){
		this.employeeService.deleteEmployee(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully" , true),HttpStatus.OK);
	}
	
	// GET - user get
	@GetMapping("/")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		return ResponseEntity.ok(this.employeeService.getAllEmployees());
	}
	
	// GET - user get
		@GetMapping("/{employeeId}")
		public ResponseEntity<EmployeeDto>getSingleEmployee(@PathVariable Integer employeeId){
			return ResponseEntity.ok(this.employeeService.getEmployeeById(employeeId));
		}
	
}
