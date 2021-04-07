package yongs.temp.httpclient.jwt;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.dto.User;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 23.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 23. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@FeignClient(name = "jwt", url = "${feign.jwt.url}")
@RequestMapping("/jwt")
public interface JwtClient {
	@PostMapping("/create") 
	public String create(@RequestBody User user);
}
