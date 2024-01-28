package com.emp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.EmployeeDTO;
import com.emp.service.EmployeeService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService emService;
	@PostMapping
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO emDto) {
		EmployeeDTO dto = emService.addEmployee(emDto);
		return new ResponseEntity(dto,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> list = emService.getAllemployees();
		return ResponseEntity.ok(list);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		emService.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted By Id : "+id);
	}	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeDTO emDto) {
		EmployeeDTO dto = emService.updateEmployee(id, emDto);
		return ResponseEntity.ok(dto);
	}
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") long id) {
		EmployeeDTO dto = emService.getEmployee(id);
		return ResponseEntity.ok(dto);
	}
	

}
