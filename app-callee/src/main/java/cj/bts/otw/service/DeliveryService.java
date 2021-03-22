package cj.bts.otw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cj.bts.framework.util.ModelMapperUtil;
import cj.bts.otw.dbmapper.DeliveryMapper;
import cj.bts.otw.dto.DeliveryDto;
import cj.bts.otw.entity.Delivery;
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
 * 
 *          <pre>
 * --------------------------------------------------------------
 * 2021. 2. 24. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 *          </pre>
 */
@Slf4j
@Service
@Transactional(value = "transactionManager", readOnly = true)
public class DeliveryService {
	@Autowired
	private DeliveryMapper deliveryMapper;

	public DeliveryDto getDeliveryInfo(String no) {
		log.info("DeliveryService.getDeliveryInfo({})", no);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			log.info("sleep({})", 30000);
		}
		Delivery delivery = deliveryMapper.findByNo(no);
		return ModelMapperUtil.map(delivery, DeliveryDto.class);
	}

	public List<DeliveryDto> getAll() {
		log.info("DeliveryService.getAll()");
		List<Delivery> deliveryList = deliveryMapper.findAll();
		return ModelMapperUtil.mapList(deliveryList, DeliveryDto.class);
	}
	
	@Transactional(value = "transactionManager")
	public int create(DeliveryDto deliveryDto) {		
		log.info("DeliveryService.create({})", deliveryDto.getNo());
		return deliveryMapper.insert(deliveryDto);
	}
	 
	@Transactional(value = "transactionManager")
	public int createRollback(DeliveryDto deliveryDto) {		
		log.info("DeliveryService.createRollback({})", deliveryDto.getNo());
		return deliveryMapper.delete(deliveryDto);
	}
}