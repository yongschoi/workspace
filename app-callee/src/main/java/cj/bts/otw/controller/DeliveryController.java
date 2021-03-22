package cj.bts.otw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cj.bts.framework.model.Json;
import cj.bts.otw.dto.DeliveryDto;
import cj.bts.otw.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 24.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 24. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Slf4j
@RequestMapping("/delivery")
@RestController
public class DeliveryController {
	@Autowired
	private DeliveryService deliveryService;
	
	@GetMapping("/no/{no}") 
	public Json<DeliveryDto> getDeliveryInto(@PathVariable("no") String no) {
		log.debug("DeliveryController.getDeliveryInto({})", no);
		
		DeliveryDto result = deliveryService.getDeliveryInfo(no);
		return Json.createJson(result, "delivery.info.retrieve.success");
	}
	
	@GetMapping("/no/all") 
	public Json<List<DeliveryDto>> getAll() {
		log.debug("DeliveryController.getAll()");
		List<DeliveryDto> result = deliveryService.getAll();
		return Json.createJson(result, "delivery.info.retrieve.success");
	}

	@PostMapping("/create") 
	public Json<Integer> create(@RequestBody DeliveryDto deliveryDto) {
		log.debug("DeliveryController.create({})", deliveryDto);		
		int result = deliveryService.create(deliveryDto);
		return Json.createJson(result);
	}
	
	@PostMapping("/createRollback") 
	public Json<Integer> createRollback(@RequestBody DeliveryDto deliveryDto) {
		log.debug("DeliveryController.createRollback({})", deliveryDto);
		int result = deliveryService.createRollback(deliveryDto);
		return Json.createJson(result);
	}
	
	@GetMapping("/test") 
	public Json<DeliveryDto> test(DeliveryDto deliveryDto) {
		log.debug("DeliveryController.test({})", deliveryDto);
		return Json.createJson(deliveryDto, "delivery.info.retrieve.success");
	}
}
