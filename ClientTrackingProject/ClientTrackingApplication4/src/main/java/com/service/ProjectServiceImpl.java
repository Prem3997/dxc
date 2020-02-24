package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProjectDAO;
import com.model.Project;
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectDAO projectDao;
	@Override
	public boolean addProject(Project project) {
		// TODO Auto-generated method stub
		return projectDao.addProject(project);
	}

	@Override
	public Project getProject(String projectId) {
		// TODO Auto-generated method stub
		return projectDao.getProject(projectId);
	}

	@Override
	public boolean isProjectExists(String projectId) {
		// TODO Auto-generated method stub
		return projectDao.isProjectExists(projectId);
	}

	@Override
	public boolean deleteProject(String projectId) {
		// TODO Auto-generated method stub
		return projectDao.deleteProject(projectId);
	}

	@Override
	public boolean updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectDao.updateProject(project);
	}

	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		return projectDao.getProjects();
	}
}
