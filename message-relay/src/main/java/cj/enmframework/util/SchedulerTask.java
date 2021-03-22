package cj.enmframework.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cj.enmframework.model.OutBoxEntity;
import cj.enmframework.service.OutBoxService;
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
@Component
public class SchedulerTask {
	@Autowired
	private OutBoxService outBoxService;
	@Autowired
	private KafkaMessageRelayer KafkaMessageRelayer; 
	
	@Scheduled(initialDelay = 5000, fixedDelay = 30000)
    public void checkOutBox() {
		List<OutBoxEntity> outbox = outBoxService.getOpenList();
		if (outbox.isEmpty()) {
		    log.info("No outbox data found");
		    return;
		} else {
			log.info("{} records found for outbox", outbox.size());
		}
		
		outbox.forEach(box -> {
			// close으로 셋팅 한 후,
			OutBoxEntity closedOutBox = outBoxService.setClose(box);
			// CLOSE가 저장된 값을 카프카로 메시지 전송
			KafkaMessageRelayer.relayMessage(closedOutBox);
		});
	}
}
