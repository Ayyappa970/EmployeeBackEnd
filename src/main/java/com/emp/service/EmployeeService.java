package com.emp.service;

import java.util.List;

import com.emp.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO addEmployee(EmployeeDTO emDto);
	List<EmployeeDTO> getAllemployees();
	void deleteEmployee(long id);
	EmployeeDTO updateEmployee(long id,EmployeeDTO emDto);
	EmployeeDTO getEmployee(long id);
}
