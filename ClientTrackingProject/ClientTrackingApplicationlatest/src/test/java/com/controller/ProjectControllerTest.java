package com.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.AbstractTest;
import com.dao.ProjectDAOImpl;
import com.model.Project;

public class ProjectControllerTest extends AbstractTest {
	@Autowired
	ProjectDAOImpl projectDaoImpl;
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	

	@Test
	public void testGetAllProjects() throws Exception {
		String uri = "/ClientTrackingApplication/project";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Project[] projectList = super.mapFromJson(content, Project[].class);
		assertTrue(projectList.length > 0);
	}
	@Test
	public void testAddProject() throws Exception {
		String uri = "/ClientTrackingApplication/project";
		   Project project=new Project("Testing", "Testing", "Testing", "Testing", "Testing", "Testing");
		   String inputJson = super.mapToJson(project);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();  
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(201, status);
		   projectDaoImpl.deleteProject("Testing");
	}
	@Test
	public void testGetProject() throws Exception {
		Project project1=new Project("Testing3", "Testing", "Testing", "Testing", "Testing", "Testing");
		projectDaoImpl.addProject(project1);
		String uri = "/ClientTrackingApplication/project/Testing3/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();	
		Project project=super.mapFromJson(content, Project.class);
		assertEquals(project.getProjectId(),"Testing3");
		projectDaoImpl.deleteProject("Testing3");
	}
	

	

	@Test
	public void testUpdateProject() throws Exception {
		String uri = "/ClientTrackingApplication/project";
		Project project=new Project("Testing1", "Testing", "Testing", "Testing", "Testing", "Testing");
		projectDaoImpl.addProject(project);
		project.setProjectManager("TESTING1");	   
		   String inputJson = super.mapToJson(project);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();  
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   projectDaoImpl.deleteProject("Testing1");
	}
	@Test
	public void testDeleteProject() throws Exception {
		Project project=new Project("Testing2", "Testing", "Testing", "Testing", "Testing", "Testing");
		projectDaoImpl.addProject(project);
		String uri = "/ClientTrackingApplication/project/Testing2/";
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
	}
}
