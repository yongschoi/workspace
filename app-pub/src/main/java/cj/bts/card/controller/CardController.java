package cj.bts.card.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cj.bts.card.dto.OrderDto;
import cj.bts.card.dto.PayDto;
import cj.bts.card.service.CardService;
import cj.bts.framework.model.Json;
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
 * @since 2021. 2. 16.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 16. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Slf4j
@RequestMapping("/bts")
@RestController
public class CardController {
	@Autowired
	private CardService cardService;
	
	@PostMapping("/order")
    public Json<Integer> createOrderInfo(@RequestBody OrderDto orderDto) {
        log.debug("fw-tpl-kfk:::CardController.createOrderInfo()");
        orderDto.setOrderTime(LocalDateTime.now());
        Integer result = cardService.createOrderInfo(orderDto);
        return Json.createJson(result);
    } 

	@PostMapping("/pay")
    public Json<Integer> createPayInfo(@RequestBody PayDto payDto) {
        log.debug("fw-tpl-kfk:::CardController.createPayInfo()");
        Integer result = cardService.createPayInfo(payDto);
        return Json.createJson(result);
    } 
	
	@GetMapping("/test")
    public Json<Integer> test() {
		List<String> list = new ArrayList<>();
		list.add("노트북");
		list.add("수입무전기");
		OrderDto dto = new OrderDto("2021-02-001", 10, LocalDateTime.now(), list);
        Integer result = cardService.createOrderInfo(dto);
        return Json.createJson(result);
    }
}
