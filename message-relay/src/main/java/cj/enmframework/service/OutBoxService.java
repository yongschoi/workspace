package cj.enmframework.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.enmframework.model.OutBoxEntity;
import cj.enmframework.repository.OutBoxRepository;
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
 * @since 2021. 2. 8.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 8. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Slf4j
@Service
public class OutBoxService {
	@Autowired
	private OutBoxRepository outBoxRepository;
	
	public List<OutBoxEntity> getOpenList() {
		return outBoxRepository.findByStatus(OutBoxEntity.Status.OPEN); 
	}

	@Transactional
	public OutBoxEntity setClose(OutBoxEntity outBox) {
		outBox.changeToCloseStatus();
		return outBoxRepository.save(outBox);
	}
	@Transactional
	public void complete(OutBoxEntity outBox) {
		outBoxRepository.delete(outBox);
	}
	@Transactional
	public void rollback(OutBoxEntity outBox) {
		log.debug("rollback start =========> " + outBox.getId());
		log.debug("rollback start =========> " + outBox.getStatus());
		outBox.changeToOpenStatus();
		log.debug("rollback changeToOpenStatus =========> " + outBox.getStatus());
		outBoxRepository.save(outBox);
	}
}
