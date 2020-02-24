package com;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dao.ClientDAOImpl;
import com.model.Client;

@SpringBootTest
@RunWith(SpringRunner.class)
class ClientTrackingApplicationTests {
	@Autowired
	ClientDAOImpl clientDAOImpl;
	@Test
	void contextLoads() {
		System.out.println("Hello");
		Client client=clientDAOImpl.getClient("1001");
		System.out.println(client);
		System.out.println("Hello");
	}

}
