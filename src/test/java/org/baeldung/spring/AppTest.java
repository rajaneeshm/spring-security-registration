package org.baeldung.spring;

import org.baeldung.Application;
import org.baeldung.web.controller.RegistrationCaptchaController;
import org.baeldung.web.controller.RegistrationController;
import org.baeldung.web.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	//private MockMvc mockMvc;

	/*@Before
	public void setUp() {
		//mockMvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}*/
	
	@Autowired
	RegistrationController registrationController;
	
	@Autowired
	UserController userController;
	
	@Autowired
	RegistrationCaptchaController registrationCaptchaController;
	

	@Test
	public void contextLoads() throws Exception {

		new SpringApplicationBuilder().sources(Application.class).build();
		Assert.assertNotNull(registrationController);
		Assert.assertNotNull(userController);
		Assert.assertNotNull(registrationCaptchaController);
		
		/*this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("index"))
				.andDo(MockMvcResultHandlers.print());*/

	}

}