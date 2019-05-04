package com.wenjie.weixinback;

import com.wenjie.weixinback.config.ResourcesPathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * @author chenwenjie
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Autowired
	private ResourcesPathConfig resourcesPathConfig;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		//配置swagger，它是在这个目录下的
				.addResourceLocations("classpath:/META-INF/resources/")
				//配置模板引擎目录
				.addResourceLocations("classpath:/templates/")
				//配置文件虚拟路径
				.addResourceLocations(resourcesPathConfig.getVirtulimagepath())
				.addResourceLocations(resourcesPathConfig.getVirtulvideopath());

		//配置静态资源的访问
		registry.addResourceHandler("/static/**").
				addResourceLocations("classpath:/static/");
	}

		@Override
	public void addInterceptors(InterceptorRegistry registry) {

	}

}
