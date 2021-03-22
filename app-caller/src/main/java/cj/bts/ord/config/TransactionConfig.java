package cj.bts.ord.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 3. 10.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 3. 10. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Configuration
public class TransactionConfig {
	@Autowired 
    private PlatformTransactionManager transactionManager;
	
	@Bean
    public TransactionTemplate transactionTemplate() {
		return new TransactionTemplate(transactionManager);
	}
}
