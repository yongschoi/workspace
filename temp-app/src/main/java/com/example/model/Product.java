package com.example.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 5.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 5. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@NoArgsConstructor
@Getter
@Setter
public class Product {
	private Long id;
    private String productNo;
    private String productName;
    private LocalDateTime expireAtDatetime;
}
