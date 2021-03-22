package cj.bts.ord.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cj.bts.framework.model.Json;
import cj.bts.ord.dto.OrderDto;
import cj.bts.ord.service.OrderService;
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
@RequestMapping("/order")
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/no/{no}") 
	public Json<OrderDto> getOrderInto(@PathVariable("no") String no) {
		log.debug("getOrderInto({})", no);
		OrderDto result = orderService.getOrderInfo(no);
		return Json.createJson(result, "order.info.retrieve.success");
	}
	
	@PostMapping("/one") 
	public Json<Integer> createOrderInfo(@RequestBody OrderDto orderDto) {
		log.debug("createOrderInfo({})", orderDto);
		orderDto.getOrderMaster().setOrderAt(LocalDateTime.now());
		return Json.createJson(orderService.crateOrderInfo(orderDto), "order.info.create.success");
	}
	
	@GetMapping("/test") 
	public Json<Integer> test(@RequestBody OrderDto orderDto) {
		log.debug("test({})", orderDto.getDeliveryDto().getCompany());
		return Json.createJson(1, "order.info.create.success");
	}
}
