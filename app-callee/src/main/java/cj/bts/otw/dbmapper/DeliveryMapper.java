package cj.bts.otw.dbmapper;

import java.util.List;

import cj.bts.otw.dto.DeliveryDto;
import cj.bts.otw.entity.Delivery;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 22.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 22. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
public interface DeliveryMapper {
	public Delivery findByNo(String no);
	public List<Delivery> findAll();
	public int insert(DeliveryDto delivery);
	public int delete(DeliveryDto delivery);
}
