package com.emp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emp.dto.EmployeeDTO;
import com.emp.entity.Employee;
import com.emp.exception.ResourceNotFound;
import com.emp.mapper.EmployeeMapper;
import com.emp.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository emRepository;
	@Override
	public EmployeeDTO addEmployee(EmployeeDTO emDto) {
		Employee employee = EmployeeMapper.mapToEmployee(emDto);
		Employee employee2 = emRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(employee2);
	}
	@Override
	public List<EmployeeDTO> getAllemployees() {
		List<Employee> list = emRepository.findAll();
		return list.stream().map((employee)-> EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
	}
	@Override
	public void deleteEmployee(long id) {
		emRepository.findById(id).orElseThrow(()->new ResourceNotFound("No employee exist by given Employee Id : "+id));
		emRepository.deleteById(id);
	}
	@Override
	public EmployeeDTO updateEmployee(long id, EmployeeDTO emDto) {
		Employee employee = emRepository.findById(id).orElseThrow(()->new ResourceNotFound("No employee exist by given Employee Id : "+id));
		employee.setFirstName(emDto.getFirstName().toUpperCase());
		employee.setLastName(emDto.getLastName().toUpperCase());
		employee.setEmail(emDto.getEmail().toLowerCase());
		employee.setMobileNumber(emDto.getMobileNumber());
		Employee employee2 = emRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(employee2);
	}
	@Override
	public EmployeeDTO getEmployee(long id) {
		Employee employee = emRepository.findById(id).orElseThrow(()->new ResourceNotFound("No Employee exist with given id : "+id));
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

}
