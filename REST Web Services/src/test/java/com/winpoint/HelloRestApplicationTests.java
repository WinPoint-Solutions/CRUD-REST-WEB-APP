package com.winpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.winpoint.controller.CustomerController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CustomerController.class)
@WebAppConfiguration
public class HelloRestApplicationTests {

	@Test
	public void contextLoads() {
	}

}
