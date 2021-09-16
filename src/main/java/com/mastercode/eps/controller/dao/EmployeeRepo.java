package com.mastercode.eps.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastercode.eps.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByid(Integer id);

}
