package cj.bts.ord.dto;

import java.util.List;

import cj.bts.ord.entity.OrderDetail;
import cj.bts.ord.entity.OrderMaster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
	private OrderMaster orderMaster;
	private List<OrderDetail> orderDetailList;
	private DeliveryDto deliveryDto;
}
