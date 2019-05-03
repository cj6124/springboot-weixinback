package com.wenjie.weixinback;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		//配置swagger，它是在这个目录下的
				.addResourceLocations("classpath:/META-INF/resources/")
				.addResourceLocations("classpath:/templates/");
		//配置静态资源的访问
		registry.addResourceHandler("/static/**").
				addResourceLocations("classpath:/static/");
	}

		@Override
	public void addInterceptors(InterceptorRegistry registry) {

	}

}
