package com.example.controller;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
 * @since 2021. 2. 3.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 3. yschoi21(yongseok.choi3@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVo {
	private String category;
	private String name;
	private String color;
	private int cost;
	private boolean domestic;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate date;
}
