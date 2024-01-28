package com.emp.mapper;

import com.emp.dto.EmployeeDTO;
import com.emp.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
		return new EmployeeDTO(employee.getId(),
		employee.getFirstName().toUpperCase(),
		employee.getLastName().toUpperCase(),
		employee.getEmail().toLowerCase(),
		employee.getMobileNumber());
	}
	public static Employee mapToEmployee(EmployeeDTO emDto) {
		return new Employee(
		emDto.getId(),
		emDto.getFirstName().toUpperCase(),
		emDto.getLastName().toUpperCase(),
		emDto.getEmail().toLowerCase(),
		emDto.getMobileNumber());
	}
}
