package com.controller;

import java.util.Set;

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
	@GetMapping("/{clientId}/project/{projectId}/")
	public ResponseEntity<Project>getProject(@PathVariable("clientId")String clientId,@PathVariable("projectId")String projectId){
		Project project=projectService.getProject(clientId, projectId);
		if(projectService.isProjectExists(projectId)) {
			return new ResponseEntity<Project>(project,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Project>(project,HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/{clientId}/project/")
	public ResponseEntity<Set<Project>>getAllProjects(@PathVariable("clientId")String clientId){
		Set<Project> allProjects=projectService.getProjects(clientId);
		return new ResponseEntity<Set<Project>>(allProjects,HttpStatus.OK);
	}
	@DeleteMapping("/{clientId}/project/{projectId}/")
	public ResponseEntity<Project>deleteProject(@PathVariable("clientId")String clientId,@PathVariable("projectId")String projectId){
		if(projectService.isProjectExists(projectId)) {
			projectService.deleteProject(clientId, projectId);
			return new ResponseEntity<Project>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
		}
	}
	@PostMapping("/{clientId}/project/")
	public ResponseEntity<Project>addProject(@PathVariable("clientId")String clientId,@RequestBody Project project){
		if(projectService.isProjectExists(project.getProjectId())) {
			return new ResponseEntity<Project>(HttpStatus.CONFLICT);
		}
		else {
			projectService.addProject(clientId, project);
			return new ResponseEntity<Project>(HttpStatus.CREATED);
		}
	}
	@PutMapping("/{clientId}/project/")
	public ResponseEntity<Project>updateProject(@PathVariable("clientId")String clientId,@RequestBody Project project){
		if(projectService.isProjectExists((project.getProjectId()))){
			projectService.updateProject(clientId, project);
			return new ResponseEntity<Project>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
		}
	}
}
