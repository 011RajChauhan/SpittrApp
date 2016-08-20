package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import spittr.data.SpittleRepositoryDao;
import spittr.data.SpittleRepositoryImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"spittr.web","spittr.data"})
public class WebConfig extends WebMvcConfigurationSupport{
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	/*@Bean
	public SpittleRepositoryDao spittleRepository(){
		System.out.println("bean created");
		return new SpittleRepositoryImpl();
	}*/
}
