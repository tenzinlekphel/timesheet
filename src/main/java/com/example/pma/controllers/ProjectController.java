package com.example.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dao.ProjectRepository;
import com.example.pma.entites.Employee;
import com.example.pma.entites.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRep;
	
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proRep.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProjectForm(Project project, Model model) {
		 proRep.save(project);
		 // use a redirect to prevent duplicat submission
		 return "redirect:/projects/new";
	}
	
}
