package yongs.temp.operation;

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
@Builder
@Data 
public class Operation {
	// 향후, 필요한 속성 추가
	private int id;
	private String email;
	private String name;
}
