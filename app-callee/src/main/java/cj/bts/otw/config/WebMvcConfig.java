package cj.bts.otw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 3. 8.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 3. 8. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
    public void addInterceptors(InterceptorRegistry registry) {

		SysColumnInterceptor sysColumnIntercepter = new SysColumnInterceptor();
        registry.addInterceptor(sysColumnIntercepter)
                .addPathPatterns()
                .excludePathPatterns();
    }
}
