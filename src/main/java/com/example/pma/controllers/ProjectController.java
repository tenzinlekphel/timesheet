package com.example.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pma.dao.ProjectRepository;
import com.example.pma.entites.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRep;
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		
		model.addAttribute("project", aProject);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProjectForm(Project project, Model model) {
		 proRep.save(project);
		 // use a redirect to prevent duplicat submission
		 return "redirect:/projects/new";
	}
	
}
