package cj.bts.ord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import cj.bts.framework.exception.BTSException;
import cj.bts.framework.model.Json;
import cj.bts.ord.dbmapper.OrderDetailMapper;
import cj.bts.ord.dbmapper.OrderMasterMapper;
import cj.bts.ord.dto.DeliveryDto;
import cj.bts.ord.dto.OrderDto;
import cj.bts.ord.entity.OrderDetail;
import cj.bts.ord.entity.OrderMaster;
import cj.bts.ord.httpclient.DeliveryClient;
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
@Service
@Slf4j
public class OrderService {	
	@Autowired
	private OrderMasterMapper orderMasterMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Autowired
	private DeliveryClient deliveryClient;
	
	@Autowired
    private TransactionTemplate transactionTemplate;
	
	// @Autowired
	// private Tracer trace;
	
	public OrderDto getOrderInfo(String no) {
		// Order 정보를 가져온다.
		OrderMaster orderMaster = orderMasterMapper.findByNo(no);
		List<OrderDetail> orderDetailList = orderDetailMapper.findByOrderNo(no);
		// Delivery 정보를 가져온다.
		Json<DeliveryDto> jsonDeliveryDto = deliveryClient.getDeliveryInfo(orderMaster.getDeliveryNo());

		OrderDto orderDto = new OrderDto();
		orderDto.setOrderMaster(orderMaster);
		orderDto.setOrderDetailList(orderDetailList);
		orderDto.setDeliveryDto(jsonDeliveryDto.getResult());
			
		return orderDto;
	}
	/*
	@Transactional
	public int crateOrderInfo(OrderDto orderDto) {	
		Span span = trace.activeSpan(); 
		String traceId = span.context().toTraceId();
		log.debug("[traceId] ===============>" + traceId);
		
		deliveryClient.create(orderDto.getDeliveryDto());
		int result = orderMasterMapper.create(orderDto.getOrderMaster());
		List<OrderDetail> ordertailList = orderDto.getOrderDetailList();
		ordertailList.forEach(ord -> {
			orderDetailMapper.create(ord);
		});
			
		return result;	
	}
	*/
	public int crateOrderInfo(OrderDto orderDto) {	
		Json<Integer> jsonResult = deliveryClient.create(orderDto.getDeliveryDto());
		if(jsonResult.isError()) throw new BTSException("order.info.create.fail");		

		return transactionTemplate.execute(status -> {
			int result = 0;
			try {
				result = orderMasterMapper.create(orderDto.getOrderMaster());
				List<OrderDetail> ordertailList = orderDto.getOrderDetailList();
				ordertailList.forEach(ord -> {
					orderDetailMapper.create(ord);
				});
			} catch (Exception e) {
				status.setRollbackOnly();
				deliveryClient.createRollback(orderDto.getDeliveryDto());
				throw new BTSException("order.info.create.fail");
			}
			return result;
		});	
	}
}
