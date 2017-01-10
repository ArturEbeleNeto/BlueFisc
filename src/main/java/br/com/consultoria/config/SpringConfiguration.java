package br.com.consultoria.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.consultoria")
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean 
	public ViewResolver getViewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}	
	
	@Bean
	public MessageSource messageSource() { 
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setCacheSeconds(1);
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
		
	}	
	
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
