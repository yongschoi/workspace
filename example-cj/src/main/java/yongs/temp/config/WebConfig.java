package yongs.temp.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import yongs.temp.operation.OperationArgumentResolver;


/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre>
 *
 * @author yschoi21
 * @since 2021. 3. 25.
 *
 * @History
 * 
 * <pre>
 * --------------------------------------------------------------
 * 2021. 3. 25. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
				// .allowedHeaders("access_token","Content-Type","X-Requested-With","accept","Origin","Access-Control-Request-Method")
				// .exposedHeaders("Access-Control-AllowHeaders","Access-Control-Allow-Origin","Access-Control-Allow-Credentials")
				// .allowCredentials(true).maxAge(3600L)
				.allowedMethods(
						HttpMethod.HEAD.name(), 
						HttpMethod.GET.name(), 
						HttpMethod.POST.name(),
						HttpMethod.PUT.name(), 
						HttpMethod.DELETE.name());
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new OperationArgumentResolver());
	}
}
