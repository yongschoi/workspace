package com.example.event.common;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

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
@Getter
@Builder
public class OutBoxEvent {
    @NonNull
    private String aggregateId;
    @NonNull
    private EventUtils.AggregateType aggregateType;
    @NonNull
    private EventUtils.EventType eventType;
    @NonNull
    private JsonNode payload;
}