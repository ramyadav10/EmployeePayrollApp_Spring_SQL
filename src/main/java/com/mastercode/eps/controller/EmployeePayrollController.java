package com.mastercode.eps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.eps.controller.dao.EmployeeRepo;
import com.mastercode.eps.model.Employee;

@RestController
public class EmployeePayrollController {

	@Autowired
	EmployeeRepo repository;
	
	@PostMapping("/saveEmployeeData")
	public String saveEmployeeData(@RequestBody Employee employee) {
		repository.save(employee);
		return "Employee Data is Saved";
	}
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return repository.findAll();
	}
	@GetMapping("/getEmployeeByID/{eID}")
	public List<Employee> getEmployeeByID(@PathVariable Integer id){
		return repository.findByid(id);
	}
}
