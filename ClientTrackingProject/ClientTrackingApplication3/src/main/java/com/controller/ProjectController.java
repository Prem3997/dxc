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
@CrossOrigin(origins = {"http://localhost:3000"})
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@GetMapping("/{projectId}/")
	public ResponseEntity<Project>getProject(@PathVariable("projectId")String projectId){
		Project project=projectService.getProject(projectId);
		if(projectService.isProjectExists(projectId)) {
			return new ResponseEntity<Project>(project,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Project>(project,HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping
	public ResponseEntity<List<Project>>getAllProjects(){
		List<Project> allProjects=projectService.getProjects();
		return new ResponseEntity<List<Project>>(allProjects,HttpStatus.OK);
	}
	@DeleteMapping("/{projectId}/")
	public ResponseEntity<Project>deleteProject(@PathVariable("projectId")String projectId){
		if(projectService.isProjectExists(projectId)) {
			projectService.deleteProject(projectId);
			return new ResponseEntity<Project>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
		}
	}
	@PostMapping
	public ResponseEntity<Project>addProject(@RequestBody Project project){
		if(projectService.isProjectExists(project.getProjectId())) {
			return new ResponseEntity<Project>(HttpStatus.CONFLICT);
		}
		else {
			projectService.addProject(project);
			return new ResponseEntity<Project>(HttpStatus.CREATED);
		}
	}
	@PutMapping
	public ResponseEntity<Project>updateProject(@RequestBody Project project){
		if(projectService.isProjectExists((project.getProjectId()))){
			projectService.updateProject(project);
			return new ResponseEntity<Project>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
		}
	}
}
