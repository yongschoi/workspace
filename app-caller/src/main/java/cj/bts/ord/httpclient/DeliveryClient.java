package cj.bts.ord.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cj.bts.framework.model.Json;
import cj.bts.ord.dto.DeliveryDto;

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
@FeignClient(name = "delivery", url = "${feign.delivery.url}")
@RequestMapping("/delivery")
public interface DeliveryClient {
	@GetMapping("/no/{no}")
	Json<DeliveryDto> getDeliveryInfo(@PathVariable("no") String no);
	
	@PostMapping("/create") 
	Json<Integer> create(@RequestBody DeliveryDto deliveryDto);
	
	@PostMapping("/createRollback") 
	Json<Integer> createRollback(@RequestBody DeliveryDto deliveryDto);
}
