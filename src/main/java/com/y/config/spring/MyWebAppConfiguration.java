package com.y.config.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 *
 * 跨域处理请求
 */
@Configuration
public class MyWebAppConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST","PUT","OPTIONS","HEADER","PATCH","DELETE")
                .maxAge(3600);
    }

	
	/**
	 * 删除springboot的历史查询格式的图片本地映射,改为走IIS映射
	 * 修改人:y
	 * 修改时间:0718
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:F/");

	}

}
