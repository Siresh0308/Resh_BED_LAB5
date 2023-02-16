package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.service.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService emplServiceImpl;
	
	@GetMapping("/")
	public String viewListOfEmployees(Model model){
		List<Employee> employees=emplServiceImpl.findAllEmployees();
		model.addAttribute("employees", employees);
		return "employees";
	}

	@GetMapping("/addnew")
	public String addNewEmployee(Model model) {
		Employee employee=new Employee();
		model.addAttribute(employee);
		return "newemployee";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		emplServiceImpl.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String updateEmployee(@PathVariable("id") int id, Model model) {
		Employee employee=emplServiceImpl.findByEmployeeId(id);
		model.addAttribute("employee", employee);
		return "updateemployee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		emplServiceImpl.deleteByEmployeeId(id);
		return "redirect:/";
	}
	
	@GetMapping("/viewEmployee/{id}")
	public String viewEmployeeById(@PathVariable("id") int id, Model model) {
		Employee employee=emplServiceImpl.findByEmployeeId(id);
		model.addAttribute("employee", employee);
		return "viewemployee";
	}
	
	@GetMapping("/searchEmployee")
	public String searchEmployee(@RequestParam("firstName") String name, Model model) {
		List<Employee> employees=emplServiceImpl.searchEmployeeByFirstName(name);
		model.addAttribute("employees", employees);
		return "employees";
	}
	
}
