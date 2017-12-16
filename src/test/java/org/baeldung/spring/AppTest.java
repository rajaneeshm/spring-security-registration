package org.baeldung.spring;

import org.baeldung.Application;
import org.baeldung.web.controller.RegistrationCaptchaController;
import org.baeldung.web.controller.RegistrationController;
import org.baeldung.web.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class AppTest {

	@Autowired
	RegistrationController registrationController;
	
	@Autowired
	UserController userController;
	
	@Autowired
	RegistrationCaptchaController registrationCaptchaController;
	

	@Test
	public void contextLoads() throws Exception {

		Assert.assertNotNull(registrationController);
		Assert.assertNotNull(userController);
		Assert.assertNotNull(registrationCaptchaController);
		

	}

}