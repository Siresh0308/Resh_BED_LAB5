package com.employeemanagement.service;

import java.util.List;

import com.employeemanagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();
	
	public Employee findByEmployeeId(int employeeId);
	
	public void saveEmployee(Employee employee);
	
	public void deleteByEmployeeId(int employeeId);
	
	public List<Employee> searchEmployeeByFirstName(String name);
	
}
