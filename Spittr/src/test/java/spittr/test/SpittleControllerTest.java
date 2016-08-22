package spittr.test;

import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spittle;
import spittr.data.SpittleRepositoryDao;
import spittr.data.SpittleRepositoryImpl;
import spittr.web.SpittleController;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.hamcrest.Matchers;
public class SpittleControllerTest {
	@Test
	public void shouldShowRecentSpittles()throws Exception{
		List<Spittle> expectedSpittles = new SpittleRepositoryImpl().createSpittleList(20);
		SpittleRepositoryDao MockSpittleRespositoryImpl = mock(SpittleRepositoryDao.class);
		when(MockSpittleRespositoryImpl.findSpittles(Long.MAX_VALUE,20)).thenReturn(expectedSpittles);
		SpittleController controller = new SpittleController(MockSpittleRespositoryImpl);
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("WEB-INF/views/spittles.jsp")).build();
		mockMvc.perform(get("/spittles")).andExpect(view().name("spittles")).
		andExpect(model().attributeExists("spittleList"));
		//andExpect(model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
	}
}
