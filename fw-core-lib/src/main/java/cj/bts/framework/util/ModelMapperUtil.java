package cj.bts.framework.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 25.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 25. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
public class ModelMapperUtil {
	private static ModelMapper modelMapper = new ModelMapper();	
	
	private static ModelMapper getModelMapper() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
	
	public static <T> T map(Object source, Class<T> targetClass) {
		return getModelMapper().map(source, targetClass);
	}
	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> getModelMapper().map(element, targetClass))
	      .collect(Collectors.toList());
	}
}
