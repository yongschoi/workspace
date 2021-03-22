package cj.enmframework.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.enmframework.model.OutBoxEntity;
import cj.enmframework.repository.OutBoxRepository;

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
@Service
public class OutBoxService {
	@Autowired
	private OutBoxRepository outBoxRepository;
	
	@Transactional
	public void create(OutBoxEntity outBox) {
		outBoxRepository.save(outBox);
	}
}
