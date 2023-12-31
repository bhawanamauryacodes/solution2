package com.employeeManagementSystem.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="employee_name" , nullable= false, length = 100)
	private String name;
	private String email;
	private String password;
	private String about;
}
