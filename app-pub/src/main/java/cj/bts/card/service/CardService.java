package cj.bts.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cj.bts.card.dto.OrderDto;
import cj.bts.card.dto.PayDto;
import cj.bts.framework.kafka.KafkaAPI;
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
 * @since 2021. 2. 26.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 26. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Slf4j
@Service
public class CardService {
	private static final String ORDER_CREATION_TOPIC = "order-creation";
	private static final String PAY_CREATION_TOPIC = "pay-creation";
	
	@Autowired
	private KafkaAPI kafkaAPI;

	@Transactional
	public int createOrderInfo(OrderDto orderDto) {  
		log.debug("fw-tpl-kfk:::CardService.createOrderInfo({})", orderDto);
		
		// 1. (DB) order 정보 저장
		// 2. (DB) card  정보 저장
		// 3. (Kafka) cash 도메인으로 orderDto 정보 pub
		kafkaAPI.pub(ORDER_CREATION_TOPIC, orderDto);
		
		return 1;
	}
	@Transactional
	public int createPayInfo(PayDto payDto) {  
		log.debug("fw-tpl-kfk:::CardService.createPayInfo({})", payDto);
		kafkaAPI.pub(PAY_CREATION_TOPIC, payDto);
		
		return 1;
	}
}
