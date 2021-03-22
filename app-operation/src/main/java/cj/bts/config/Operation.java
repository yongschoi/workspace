package cj.bts.config;

import lombok.Builder;
import lombok.Data;

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
@Builder
@Data
public class Operation {
	private String id;
	private String empNo;
	private String ipAddress;
}
