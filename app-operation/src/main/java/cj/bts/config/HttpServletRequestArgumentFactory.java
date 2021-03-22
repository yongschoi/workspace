package cj.bts.config;
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
public interface HttpServletRequestArgumentFactory<T, HttpServletRequest> {
	public T getObject(HttpServletRequest httpServletRequest);
}
