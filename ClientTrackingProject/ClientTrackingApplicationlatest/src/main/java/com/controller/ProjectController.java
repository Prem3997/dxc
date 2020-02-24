package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Project;
import com.service.ProjectService;

@RestController
@RequestMapping("ClientTrackingApplication/project")
@CrossOrigin(origins = { "http://localhost:3000" })
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	//For getting Project detail by projectId
	@GetMapping("/{projectId}/")
	public ResponseEntity<Project> getProject(@PathVariable("projectId") String projectId) {
		Project project = projectService.getProject(projectId);
		if (projectService.isProjectExists(projectId)) {
			return new ResponseEntity<Project>(project, HttpStatus.OK);
		} else {
			return new ResponseEntity<Project>(project, HttpStatus.NO_CONTENT);
		}
	}

	//For getting a list of All project details
	@GetMapping
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> allProjects = projectService.getProjects();
		return new ResponseEntity<List<Project>>(allProjects, HttpStatus.OK);
	}

	//For deleting a project with ProjectId
	@DeleteMapping("/{projectId}/")
	public ResponseEntity<Project> deleteProject(@PathVariable("projectId") String projectId) {
		if (projectService.isProjectExists(projectId)) {
			projectService.deleteProject(projectId);
			return new ResponseEntity<Project>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
		}
	}

	//For adding a project
	@PostMapping
	public ResponseEntity<Project> addProject(@RequestBody Project project) {
		if (projectService.isProjectExists(project.getProjectId())) {
			return new ResponseEntity<Project>(HttpStatus.CONFLICT);
		} else {
			projectService.addProject(project);
			return new ResponseEntity<Project>(HttpStatus.CREATED);
		}
	}
	
	//For Updating a project
	@PutMapping
	public ResponseEntity<Project> updateProject(@RequestBody Project project) {
		System.out.println("update project called");
		if (projectService.isProjectExists((project.getProjectId()))) {
			projectService.updateProject(project);
			return new ResponseEntity<Project>(HttpStatus.OK);

		} else {
			return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
		}
	}
}
