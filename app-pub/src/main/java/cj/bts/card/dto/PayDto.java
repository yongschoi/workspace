package cj.bts.card.dto;

import java.util.List;

import cj.bts.card.entity.Card;
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
 * @since 2021. 2. 17.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 17. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayDto {
	private String payType;
	private String payCompany;
	private List<Card> cardList;
}
