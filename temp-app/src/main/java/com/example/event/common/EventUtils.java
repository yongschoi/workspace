package com.example.event.common;

import java.time.format.DateTimeFormatter;

import com.example.model.ProductEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 5.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 5. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
public class EventUtils {

    private EventUtils() {
    }

    public enum AggregateType {
        PRODUCT
    }

    public enum EventType {
        INSERT, UPDATE, DELETE
    }

    public static OutBoxEvent createProductEvent(ProductEntity productEntity, EventType eventType) {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")));
        mapper.registerModule(javaTimeModule); // LocalDateTime을 Json으로 출력시 format 지정
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE); // java 객체의 property name을 DB 컬럼명에 맞게 snake_case로 출력
        
        JsonNode jsonNode = mapper.convertValue(productEntity, JsonNode.class); 
        
        return OutBoxEvent.builder()
                .aggregateId(productEntity.getProductNo())
                .aggregateType(AggregateType.PRODUCT)
                .eventType(eventType)
                .payload(jsonNode).build();
    }
}