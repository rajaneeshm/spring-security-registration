package org.baeldung.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class,PersistenceJPAConfig.class,SecSecurityConfig.class,
		AppConfig.class,CaptchaConfig.class})
@WebAppConfiguration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "org.baeldung.spring", "org.baeldung.service", "org.baeldung.registration","org.baeldung.web.controller" })
public class AppTest {
	private MockMvc mockMvc;
        
        @Autowired
        private WebApplicationContext webAppContext;
     
        @Before
        public void setup() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        }
       /* @Before
        public void setUp() {
         mockMvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
        }*/
        @Test
        public void testIndex() throws Exception{
               this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("index"))
                    .andDo(MockMvcResultHandlers.print());
        }
}