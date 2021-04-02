package yongs.temp.httpclient.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.dto.Product;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 23.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 23. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@FeignClient(name = "product", url = "${feign.product.url}")
@RequestMapping("/product")
public interface ProductClient { 
	@GetMapping("/all")
	public List<Product> findByAll();
}
