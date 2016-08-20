package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// this method return the root configuration beans that are the application context part acts as middle tier for the app
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// this method returns the application context that holds all the beans
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// it takes request of type "/", ie for all request we can define here any type of request like .html or any resource
		return new String[]{"/"};
	}
	
}
