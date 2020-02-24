package com.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProjectDao;
import com.model.Project;
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectDao projectDao;
	@Override
	public boolean addProject(String clientId, Project project) {
		// TODO Auto-generated method stub
		System.out.println("Project Service Called");
		return projectDao.addProject(clientId, project);
	}

	@Override
	public Project getProject(String clientId, String projectId) {
		// TODO Auto-generated method stub
		return projectDao.getProject(clientId, projectId);
	}

	@Override
	public boolean isProjectExists(String projectId) {
		// TODO Auto-generated method stub
		return projectDao.isProjectExists(projectId);
	}

	@Override
	public boolean deleteProject(String clientId, String projectId) {
		// TODO Auto-generated method stub
		return projectDao.deleteProject(clientId, projectId);
	}

	@Override
	public boolean updateProject(String clientdId, Project project) {
		// TODO Auto-generated method stub
		return projectDao.updateProject(clientdId, project);
	}

	@Override
	public Set<Project> getProjects(String clientId) {
		// TODO Auto-generated method stub
		return projectDao.getProjects(clientId);
	}

}
