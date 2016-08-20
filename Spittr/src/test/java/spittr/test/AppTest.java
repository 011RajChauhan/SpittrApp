package spittr.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spittr.web.HomeController;

public class AppTest {
	@Test
	public void testHomePage(){
		HomeController controller = new HomeController();
		assertEquals("home",controller.home());
	}
}
