package cj.bts.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 3. 15.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 3. 15. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Service
@RefreshScope
public class ConfigService {
	@Value("${bts.say}")
	private String say;
	
	public Object getConfig() {
		return say;
	}
}
