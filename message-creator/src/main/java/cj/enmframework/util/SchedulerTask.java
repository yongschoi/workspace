package cj.enmframework.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cj.enmframework.model.OutBoxEntity;
import cj.enmframework.service.OutBoxService;

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
@Component
public class SchedulerTask {	
	@Autowired
	private OutBoxService outBoxService;
	
	@Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void createOutBox() {
		OutBoxEntity input = new OutBoxEntity("test", "{\"id\":1,\"product_no\":\"1001\",\"product_name\":\"Coffee\"}", OutBoxEntity.Status.OPEN);
		outBoxService.create(input);	
	}
}
