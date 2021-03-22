package com.example.event.repository;

import org.springframework.stereotype.Component;

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
 * @since 2021. 2. 8.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 8. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@RequiredArgsConstructor
@Component
public class OutBoxAdapter {
	private final OutBoxRepository outBoxRepository;
 
	public void save(OutBoxEntity outBoxEntity) {
		outBoxRepository.save(outBoxEntity);
	}
}
