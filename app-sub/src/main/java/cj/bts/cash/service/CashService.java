package cj.bts.cash.service;

import org.springframework.stereotype.Service;

import cj.bts.cash.dto.OrderDto;
import cj.bts.cash.dto.PayDto;
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
@Service
public class CashService {
	public void createOrderInfo(OrderDto orderDto) {
		// (DB) cash  정보 저장
		log.debug("주문정보 ===> [" + orderDto.toString() + "]");
	}
	public void createPayInfo(PayDto payDto) {
		// (DB) Pay  정보 저장
		log.debug("Pay정보 ===> [" + payDto.toString() + "]");
	}	
}
