package cj.bts.otw.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 *
 * This software is the proprietary information of CJ OliveNetworks
 * </pre>
 *
 * @author shmo21
 * @since 2021. 2. 18.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 18. shmo21(shmo21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Configuration
@MapperScan(basePackages="cj.bts.otw.dbmapper")
public class MybatisConfig {
}
