package com.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.model.Project;
import com.mongodb.client.result.UpdateResult;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	@Autowired
	MongoTemplate template;

	@Override
	public boolean addProject(Project project) {
		if (isProjectExists(project.getProjectId())) {
			return false;
		} else {
			template.save(project);
			return true;
		}
	}

	@Override
	public Project getProject(String projectId) {
		System.out.println("GetProjectByIdCalled");
		List<Project> allProjects = getProjects();
		for (Project x : allProjects) {
			if (projectId.equals(x.getProjectId())) {
				return x;

			} else {
				continue;
			}
		}
		return null;
	}

	@Override
	public boolean isProjectExists(String projectId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("projectId").is(projectId));
		Project project = template.findOne(query, Project.class, "project");
		if (project == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteProject(String projectId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("projectId").is(projectId));
		Project projectToBeDeleted = template.findAndRemove(query, Project.class, "project");
		if (projectToBeDeleted == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateProject(Project project) {
		Query query = new Query();
		query.addCriteria(Criteria.where("projectId").is(project.getProjectId()));
		Update update = new Update();
		update.set("projectName", project.getProjectName());
		update.set("chapterToWhichBelongs", project.getChapterToWhichBelongs());
		update.set("projectManager", project.getProjectManager());
		update.set("projectVersion", project.getProjectVersion());
		update.set("projectStatus", project.getProjectStatus());
		UpdateResult writeResult = template.updateFirst(query, update, Project.class);
		long rowsAffected = writeResult.getModifiedCount();
		if (rowsAffected == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Project> getProjects() {
		return template.findAll(Project.class);
	}

}
