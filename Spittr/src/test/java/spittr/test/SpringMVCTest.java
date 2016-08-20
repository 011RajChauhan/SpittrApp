package spittr.test;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import spittr.web.HomeController;

public class SpringMVCTest {
	@Test
	public void testHomePage()throws Exception{
		HomeController controller = new HomeController();
		MockMvc mvc= standaloneSetup(controller).build();
		mvc.perform(get("/")).andExpect(view().name("home"));
	}
}
