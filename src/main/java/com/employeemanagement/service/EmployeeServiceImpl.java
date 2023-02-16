package com.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee findByEmployeeId(int employeeId) {
		Employee theEmployee=null;
		Optional<Employee> result=repository.findById(employeeId);
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			throw new RuntimeException("could not find the employee with employee id--"+employeeId);
		}
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		repository.save(employee);
		
	}

	@Override
	public void deleteByEmployeeId(int employeeId) {
		repository.deleteById(employeeId);
		
	}

	@Override
	public List<Employee> searchEmployeeByFirstName(String name) {
		Employee employeesMatchingWithFirstName=new Employee();
		employeesMatchingWithFirstName.setEmployeeFirstName(name);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("employeeFirstName",
				ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("employeeId", "employeeLastName", "employeeEmail");
		Example<Employee> example=Example.of(employeesMatchingWithFirstName, exampleMatcher); 
		List<Employee> employees=repository.findAll(example);
		
		
		return employees;
		
	}

}
