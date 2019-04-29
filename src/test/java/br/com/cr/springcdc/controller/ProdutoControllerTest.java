package br.com.cr.springcdc.controller;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.cr.springcdc.config.AppWebConfiguration;
import br.com.cr.springcdc.config.DataSourceConfigurationTest;
import br.com.cr.springcdc.config.JPAConfiguration;
import br.com.cr.springcdc.config.SecurityConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JPAConfiguration.class, AppWebConfiguration.class,
		DataSourceConfigurationTest.class, SecurityConfiguration.class})
@ActiveProfiles("test")
public class ProdutoControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
    private Filter springSecurityFilterChain;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac)
				.addFilter(springSecurityFilterChain).build();
	}
	
	@Test
	public void deveRetornarParaHomeComLivros() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.model().attributeExists("produtos"))
			.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/home/home.jsp"));
	}
	
	@Test
	public void somenteAdminDeveAcessarProdutoForm() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/produto/form")
				.with(SecurityMockMvcRequestPostProcessors
						.user("user@user.com.br")
						.roles("USUARIO")))
				.andExpect(MockMvcResultMatchers.status().is(403));
	}
	
}
