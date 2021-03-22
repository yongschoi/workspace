package cj.bts.framework.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import cj.bts.framework.util.MessageUtil;
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
 * @since 2021. 1. 28.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 1. 28. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre> 
 */
@Data
public class Json<T> implements CommonJson<T> {
    private int status;
    private String message;
    private T result;

    public static class JsonBuilder {
        Map<String, Object> jsonResultMap;

        public JsonBuilder() {
            jsonResultMap = new HashMap<>();
        }

        public Json<Map<String, Object>> build() {
            Json<Map<String, Object>> jsonResult = new Json<>();
            jsonResult.setResult(jsonResultMap);
            return jsonResult;
        }

        public JsonBuilder map(String key, Object value) {
            jsonResultMap.put(key, value);
            return this;
        }

        public static JsonBuilder builder() {
            return new JsonBuilder();
        }
    }

    public static <T> Json<T> createJson(T result) {
        return createJson(result, HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }

    public static <T> Json<T> createJson(T result, String messageCode) {
        return createJson(result, MessageUtil.getMessage(messageCode), HttpStatus.OK.value());
    }
  
    public static <T> Json<T> createJson(T result, String messageCode, Object[] args) {
        return createJson(result, MessageUtil.getMessage(messageCode, args), HttpStatus.OK.value());
    }
 
    public static <T> Json<T> createJson(T result, HttpStatus status) {
        return createJson(result, null, HttpStatus.OK.value());
    }
    
    public static <T> Json<T> createJson(T result, String message, int status) {
        Json<T> json = new Json<T>();
        json.setResult(result);
        json.setMessage(message);
        json.setStatus(status);

        return json;
    }
    
    public static <T> Json<T> createErrorJson(String messageCode) {
        return createErrorJson(MessageUtil.getMessage(messageCode), HttpStatus.NO_CONTENT.value());
    }
    
    public static <T> Json<T> createErrorJson(String messageCode, Object[] args) {
        return createErrorJson(MessageUtil.getMessage(messageCode, args), HttpStatus.NO_CONTENT.value());
    }
    
    public static <T> Json<T> createErrorJson(String messageCode, Object[] args, HttpStatus status) {
        return createErrorJson(MessageUtil.getMessage(messageCode, args), status.value());
    } 
    
    public static <T> Json<T> createErrorJson(String message, int status) {
        Json<T> json = new Json<T>();
        json.setMessage(message);
        json.setStatus(status);

        return json;
    }
    
    public Boolean isError() {
        return (status != HttpStatus.OK.value());
    }
}