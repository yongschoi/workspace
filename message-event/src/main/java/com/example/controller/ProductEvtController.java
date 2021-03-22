package com.example.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductEvtController {
	@Autowired
	ProductService productService;
    @PostMapping("/create")
    public void create(@RequestBody Product product) throws Exception{
    	log.debug("temp-app|ProductEvtController|create({})");
    	
    	product.setExpireAtDatetime(LocalDateTime.now());
    	productService.save(product);
    }
    
}
