package cj.bts.framework.model;
/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 1. 29.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 1. 29. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
public interface CommonJson<T> {
	public Boolean isError();
	public String getMessage();
	public T getResult();
} 
