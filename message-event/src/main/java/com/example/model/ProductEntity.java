package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
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
 * @since 2021. 2. 5.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 5. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Getter
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productNo;
    private String productName;
    private LocalDateTime expireAtDatetime;
}
