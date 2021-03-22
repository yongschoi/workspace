package cj.bts.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 1. 28.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 1. 28. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Configuration
public class OpenAPIConfig {
    @Value("${spring.application.name}")
    private String appName;
    @Value("${springdoc.version:v1}")
    private String version;
    
    @Bean
    public OpenAPI cjoSalesOpenAPI() {
    	return new OpenAPI()
                .info(new Info().title(appName + " API")
                .version(version));
    }
}