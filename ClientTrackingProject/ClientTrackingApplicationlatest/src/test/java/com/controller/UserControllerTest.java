package com.controller;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.AbstractTest;
import com.dao.UserDAOImpl;


public class UserControllerTest extends AbstractTest {
	@Autowired
	UserDAOImpl userDaoImpl;
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	@Test
	public void testIsValidUser() throws Exception {
		String uri = "/ClientTrackingApplication/user/admin/admin/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
