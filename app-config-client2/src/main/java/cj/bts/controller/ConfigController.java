package cj.bts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cj.bts.service.ConfigService;

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
@RequestMapping("/bts")
@RestController
public class ConfigController {
	@Autowired
	private ConfigService configService;
	
	@GetMapping(value = "/config")
	public Object getConfig() {
		return configService.getConfig();
	}
}
