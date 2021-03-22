package cj.bts.cash.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import cj.bts.cash.dto.OrderDto;
import cj.bts.cash.dto.PayDto;
import cj.bts.cash.service.CashService;
import cj.bts.framework.kafka.KafkaAPI;

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
@Component
public class CashSubscriber {
	private static final String ORDER_CREATION_TOPIC = "order-creation";
	private static final String PAY_CREATION_TOPIC = "pay-creation";
	
	@Autowired
	private KafkaAPI kafkaAPI;
	@Autowired
	private CashService cashService;
	
	@KafkaListener(topics = ORDER_CREATION_TOPIC)
	public void createOrderInfo(String messageStr) {
		OrderDto orderDto = kafkaAPI.sub(messageStr, OrderDto.class);
		cashService.createOrderInfo(orderDto);
	}
	@KafkaListener(topics = PAY_CREATION_TOPIC)
	public void createPayInfo(String messageStr) {
		PayDto payDto = kafkaAPI.sub(messageStr, PayDto.class);
		cashService.createPayInfo(payDto);
	}
}
