package com.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.AbstractTest;
import com.dao.ClientDAOImpl;
import com.model.Client;

public class ClientControllerTest extends AbstractTest {
	@Autowired
	ClientDAOImpl clientDAOImpl;
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testGetClients() throws Exception {
		String uri = "/ClientTrackingApplication/client";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Client[] clientList = super.mapFromJson(content, Client[].class);
		assertTrue(clientList.length > 0);
	}


	@Test
	public void testAddClient() throws Exception {
		String uri = "/ClientTrackingApplication/client";
		   Client client=new Client("Testing", "Testing", "Testing", "Testing", "Testing", "Testing");
		   String inputJson = super.mapToJson(client);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();  
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(201, status);
	}
	@Test
	public void testGetClient() throws Exception {
		//fail("Not yet implemented");
		String uri = "/ClientTrackingApplication/client/Testing/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();	
		Client client=super.mapFromJson(content, Client.class);
		assertEquals(client.getClientId(), "Testing");
		clientDAOImpl.deleteClient("Testing");
		
	}
	@Test
	public void testUpdateClient() throws Exception {
		String uri = "/ClientTrackingApplication/client";
		Client client=new Client("Testing1", "Testing", "Testing", "Testing", "Testing", "Testing");
		clientDAOImpl.addClient(client);
		client.setClientCompanyName("TESTING1");	   
		   String inputJson = super.mapToJson(client);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();  
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   clientDAOImpl.deleteClient("Testing1");
	}

	@Test
	public void testDeleteClient() throws Exception {
		//fail("Not yet implemented");
		Client client=new Client("Testing2", "Testing", "Testing", "Testing", "Testing", "Testing");
		clientDAOImpl.addClient(client);
		String uri = "/ClientTrackingApplication/client/Testing2/";
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
	}

}
