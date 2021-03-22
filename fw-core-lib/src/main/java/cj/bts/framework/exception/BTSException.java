package cj.bts.framework.exception;
/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 3. 3.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 3. 3. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
public class BTSException extends RuntimeException {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BTSException() {
		super();
	}
	public BTSException(String messageCode) {
		super(messageCode);
	}
	public BTSException(String messageCode, Throwable cause) {
		super(messageCode, cause);
	}
	public BTSException(Throwable cause) {
		super(cause);
	}
}
