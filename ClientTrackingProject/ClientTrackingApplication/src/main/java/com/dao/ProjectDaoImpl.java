package com.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.model.Client;
import com.model.Project;
import com.mongodb.client.result.UpdateResult;
import com.service.ClientService;
@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	MongoTemplate template;
	@Autowired
	ClientService  clientService;
	@Override
	public boolean addProject(String clientId, Project project) {
		// TODO Auto-generated method stub
		System.out.println(" Project Impl callled");
		if(isProjectExists(project.getProjectId())) {
			return false;
		}
		else {
			Client client=clientService.getClient(clientId);
			project.setClient(client);
			client.getClientProjects().add(project);
			template.save(project);
			template.save(client);
			return true;
		}	
	}

	@Override
	public Project getProject(String clientId, String projectId) {
		// TODO Auto-generated method stub
		Client client=clientService.getClient(clientId);
		Set<Project> allProjects=client.getClientProjects();
		for(Project x : allProjects) {
			if(projectId==x.getProjectId()) {
				return x;
			}
			else {
				continue;
			}
		}
		return null;
	}

	@Override
	public boolean isProjectExists(String projectId) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("projectId").is(projectId));
		Project project=template.findOne(query,Project.class,"project");
		if(project==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean deleteProject(String clientId, String projectId) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("projectId").is(projectId));
		Project projectToBeDeleted=template.findAndRemove(query,Project.class,"project");
		if(projectToBeDeleted==null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateProject(String clientId, Project project) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("projectId").is(project.getProjectId()));
		Update update=new Update();
		update.set("projectName",project.getProjectName());
		update.set("chapterToWhichBelongs",project.getChapterToWhichBelongs());
		update.set("projectManger",project.getProjectManger());
		update.set("projectVersion",project.getProjectVersion());
		update.set("projectStatus",project.getProjectStatus());
		UpdateResult writeResult=template.updateFirst(query, update, Client.class);
		long rowsAffected=writeResult.getModifiedCount();
		if(rowsAffected==0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public Set<Project> getProjects(String clientId) {
		// TODO Auto-generated method stub
		Client client=clientService.getClient(clientId);
		
		return client.getClientProjects();
	}

}
