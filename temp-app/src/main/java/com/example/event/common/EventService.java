package com.example.event.common;

import java.time.LocalDateTime;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.event.repository.OutBoxAdapter;
import com.example.event.repository.OutBoxEntity;

import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 6.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 6. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@RequiredArgsConstructor
@Service
public class EventService {
    private final OutBoxAdapter outBoxAdapter;

    @EventListener
    public void handleOutBoxEvent(OutBoxEvent event) {
        OutBoxEntity outBox = OutBoxEntity.builder()
        		.aggregateId(event.getAggregateId())
                .aggregateType(event.getAggregateType().name())
                .eventType(event.getEventType().name())
                .payload(event.getPayload().toString())
                .createdAtDatetime(LocalDateTime.now())
                .build();
        outBoxAdapter.save(outBox);
    }
}