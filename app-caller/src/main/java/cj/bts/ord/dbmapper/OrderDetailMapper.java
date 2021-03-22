package cj.bts.ord.dbmapper;

import java.util.List;

import cj.bts.ord.entity.OrderDetail;

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
public interface OrderDetailMapper {
	public List<OrderDetail> findByOrderNo(String orderNo);
	public int create(OrderDetail orderDeatil);
}
