package com.example.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.entites.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@RequestMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee", anEmployee);
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Model model, Employee employee) {
		// save to the database using CRUD repository
		empRepo.save(employee);
		return "redirect:/new";
		
	}
	
	
	

}
