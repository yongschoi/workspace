package cj.bts.framework.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cj.bts.framework.exception.BTSException;
import cj.bts.framework.model.Json;
/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 1.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 1. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>       
 */
@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(MethodArgumentNotValidException.class) 
    public Json<String> methodArgumentNotValid(MethodArgumentNotValidException e) { 
        return Json.createErrorJson(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST.value());
    }	
	@ExceptionHandler(BTSException.class) 
    public Json<String> btsErr(BTSException e) {
		e.printStackTrace();
        return Json.createErrorJson(e.getMessage());
    }
	@ExceptionHandler(Throwable.class) 
    public Json<String> err(Throwable e) { 
		e.printStackTrace();
        return Json.createErrorJson("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
