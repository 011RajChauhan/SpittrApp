package spittr.test;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import spittr.web.SpitterController;

public class SpitterControllerTest {
	@Test
	public void shouldShowRegistrationForm()throws Exception{
		/*SpitterController controller = new SpitterController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));*/
	}
}
