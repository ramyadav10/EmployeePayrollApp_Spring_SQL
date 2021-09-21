package com.mastercode.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.demo.dao.EmployeeRepo;
import com.mastercode.demo.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepo repository;
	
	@PostMapping("/toPost")
	public String toPost(@RequestBody Employee employee) {
		repository.save(employee);
		return "Employee Data is Saved...!";
	}
	@GetMapping("/toGetAll")
	public List<Employee> getAll(){
		return repository.findAll();
	}
	@GetMapping("/getByID/{eId}")
	public List<Employee> getByID(@PathVariable Integer eId) {
	
		return (List<Employee>) repository.findByeId(eId);
	}
	@PutMapping("/updateByID/{eId}")
	public String updateByID(@PathVariable Integer eId,@RequestBody Employee employee) {
		Employee entityData=repository.findByeId(eId);
		entityData.seteName(employee.geteName());
		entityData.setDepartment(employee.getDepartment());
		entityData.setSalary(employee.getSalary());
		repository.save(entityData);
		return "Update is done";
	}
}
