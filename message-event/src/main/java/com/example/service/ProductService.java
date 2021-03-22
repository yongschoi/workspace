package com.example.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.event.common.EventPublisher;
import com.example.event.common.EventUtils;
import com.example.model.Product;
import com.example.model.ProductEntity;
import com.example.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 5.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 5. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductRepository productRepository;
    private final EventPublisher eventPublisher;
  
	@Transactional
	public void save(Product product) {
		ProductEntity productEntity = ProductEntity.builder()
				.productNo(product.getProductNo())
				.productName(product.getProductName())
				.expireAtDatetime(product.getExpireAtDatetime())
				.build();
		
		productRepository.save(productEntity);
        eventPublisher.publish(EventUtils.createProductEvent(productEntity, EventUtils.EventType.INSERT));
	}

}
