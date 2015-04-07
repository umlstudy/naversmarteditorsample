package org.sample.naversmarteditor.springconfig.servlet;

import org.sample.naversmarteditor.springconfig.reslover.MyContentNegotiatingViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAspectJAutoProxy
@Profile("real")
@ComponentScan(basePackages= {
		 "org.sample.naversmarteditor.controller"
		,"org.sample.naversmarteditor.service"
})
public class SpringMvcConfig extends WebMvcConfigurationSupport {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = 
                    new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		return new MyContentNegotiatingViewResolver();
	}
	
	/** 
	 * 추가 인터셉터
	 */
	protected void addInterceptors(InterceptorRegistry registry) {
	    super.addInterceptors(registry);
	}
	
//	@Bean
//	public MessageSource messageSource() {
//	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//	    messageSource.setBasename("messages");
//	    return messageSource;
//	}
}