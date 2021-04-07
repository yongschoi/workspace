package yongs.temp.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import yongs.temp.dto.Product;
import yongs.temp.dto.User;
import yongs.temp.httpclient.product.ProductClient;
import yongs.temp.operation.Operation;

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
@Slf4j
@RequestMapping("/cj")
@RestController
public class Controller {	
	private final String secretKey = "BTSTokenKey";
	private String token = "";

	@Autowired
	private ProductClient productClient;
	
	@GetMapping("/test") 
	public Operation test(Operation operation) { 
		log.debug("example-cj|Controller|test({})", operation.getName());
		return operation;
	}

	@GetMapping("/jwt/a") 
	public String jwtA() { 
		User user = new User();
		user.setId("11111");
		user.setEmail("aaa@naver.com");
		user.setName("똠방각하");
		this.token = createToken(user);
		return this.token;
	}
	@GetMapping("/jwt/a/parse") 
	public User parseA() { 
		Claims claims = parse(this.token);
		User user = new User();
		user.setId(claims.get("id", String.class));
		user.setEmail(claims.get("email", String.class));
		user.setName(claims.get("name", String.class));
		
		return user;
	}
	
	@GetMapping("/jwt/b") 
	public String jwtB() { 
		User user = new User();
		user.setId("99999");
		user.setEmail("bbb@naver.com");
		user.setName("롹앤롤");
		this.token = createAccessToken(user);
		return this.token;
	}

	@GetMapping("/jwt/b/parse") 
	public User parseB() { 
		Claims claims = parse(this.token);

		User user = new User();
		user.setId(claims.getSubject());
		user.setEmail(claims.get("email", String.class));
		user.setName(claims.get("name", String.class));
		
		return user;
	}	
	@GetMapping("/product/all") 
	public List<Product> product(Operation operation) { 
		log.debug("example-cj|Controller|product({})", operation.getName());
		return productClient.findByAll(operation.getToken());
	}
	
	private String createToken(User user) {
		Map<String, Object> headers = new HashMap<>();
		headers.put("typ", "JWT");
		headers.put("alg", "HS256");
		
		Map<String, Object> payloads = new HashMap<>();
		payloads.put("id", user.getId());
		payloads.put("email", user.getEmail());
		payloads.put("name", user.getName());
		
		return Jwts.builder()
				.setHeader(headers)
				.setClaims(payloads)
				.signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
				.compact();
	}
	
    private String createAccessToken(User user) {
    	// Payload : userId + name + roles
    	Claims claims = Jwts.claims().setSubject(user.getId());
    	claims.put("email", user.getEmail());
    	claims.put("name", user.getName());
    	Date now = new Date();
    	
    	return Jwts.builder()
    			.setHeaderParam("typ", "JWT")
    			.setClaims(claims)
    			.setIssuedAt(now)
    			.signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
    			.compact();
    }
    private Claims parse(String jwt) {
		return  Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt).getBody();
	}
	
	private String generateKey(){
    	return Base64.getEncoder().encodeToString(this.secretKey.getBytes());
    }
}
