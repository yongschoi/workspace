package cj.bts.config;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 3. 10.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 3. 10. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
public class OperationFactory implements HttpServletRequestArgumentFactory<Operation, HttpServletRequest> {
	@Override
	public Operation getObject(HttpServletRequest httpServletRequest) {
		String ipAddress = httpServletRequest.getRemoteAddr();
		Operation op = Operation.builder()
				.id("hong")
				.empNo("11111")
				.ipAddress(ipAddress)
				.build();
		return op;
	}
}
