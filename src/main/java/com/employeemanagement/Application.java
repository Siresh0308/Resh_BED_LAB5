package com.employeemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeemanagement.service.EmployeeService;

@SpringBootApplication(scanBasePackages = {"com.gl.employeemanagement"})
public class Application implements CommandLineRunner {

	@Autowired
	EmployeeService employeeServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("List Of employees.."+employeeServiceImpl.findAllEmployees());
		
		
	}

}
