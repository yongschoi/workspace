package cj.bts.ord.entity;

import java.time.LocalDateTime;

import lombok.Getter;

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
@Getter
public class OrderMaster {
	private String no;
	private String customerId;
	private String customerName;
	private String pay;
	private int amount;
	private LocalDateTime orderAt;
	private String deliveryNo;
	
	public void setOrderAt(LocalDateTime orderAt) {
		this.orderAt = orderAt;
	}
}
