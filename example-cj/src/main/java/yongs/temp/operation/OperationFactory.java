package yongs.temp.operation;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre>
 *
 * @author yschoi21
 * @since 2021. 3. 25.
 *
 * @History
 * 
 * <pre>
 * --------------------------------------------------------------
 * 2021. 3. 25. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
public class OperationFactory {
	private final String secretKey = "BTSTokenKey";
	private static final String ACCESS_TOKEN = "access-token";
	
	public Operation getObject(HttpServletRequest httpServletRequest) { 
		// httpServletRequest에서 TOKEN정보를 가져온다.
		// TOKEN정보에서 사용자 ID, 사용자 NO 등등 필요정보를 추출해서
		// Operation에 셋팅하다.
		String token = httpServletRequest.getHeader(ACCESS_TOKEN);
		Claims claims = parse(token);
		Operation operation = Operation.builder() 
				.id(claims.get("id", Integer.class))
				.email(claims.get("email", String.class))
				.name(claims.get("name", String.class))
				.token(token)
				.build();
		return operation; 
	}
	
	private Claims parse(String jwt) {
		return  Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt).getBody();
	}
	
	private String generateKey(){
    	return Base64.getEncoder().encodeToString(this.secretKey.getBytes());
    }
}
