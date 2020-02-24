package com.service;

import java.util.Set;

import com.model.Project;

public interface ProjectService {
	public boolean addProject(String clientId,Project project);
	public Project getProject(String clientId,String projectId);
	public boolean isProjectExists(String projectId);
	public boolean deleteProject(String clientId,String projectId);
	public boolean updateProject(String clientdId,Project project);
	public Set<Project>getProjects(String clientId);
}
