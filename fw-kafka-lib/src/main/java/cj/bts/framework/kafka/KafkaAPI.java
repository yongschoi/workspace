package cj.bts.framework.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 24.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 24. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */ 
@Slf4j
@Component
public class KafkaAPI {
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void pub(String topic, Object messageObject) {
		String _tempStr = null;
		long messageId = System.currentTimeMillis();

		try {
			_tempStr = objectMapper.writeValueAsString(messageObject);	
		} catch (JsonProcessingException e) {
			throw new RuntimeException("FW-KafkaAPI.pub() ::: Object to String Convert ERROR, topic=[" + topic + "]", e);
		}
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, _tempStr);	
		log.info("[Kafka-Tx-start:" + messageId + "] " + topic + "=" + _tempStr);
		future.addCallback(new KafkaSendCallback<String, String>() {
		    @Override
		    public void onSuccess(SendResult<String, String> result) {
		    	log.info("[Kafka-Tx-end:" + messageId + "] with offset=[" + result.getRecordMetadata().offset() + "]");
		    }
  
		    @Override
		    public void onFailure(KafkaProducerException ex) {
		        ProducerRecord<String, String> failed = ex.getFailedProducerRecord();
		        log.error("Unable to send message=[TOPIC: "+ failed.topic() +", MESSAGE: " + failed.value() + "]\n"
		        + "due to : " + ex.getMessage());
		    }
		});

	}
	
	public <T> T sub(String messageStr, Class<T> responseType)  {
		T result = null;
		try {
			result = objectMapper.readValue(messageStr, responseType);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("FW-KafkaAPI.sub() ::: String to Object Convert ERROR, message=[" + messageStr + "]", e);
		}
		return result;
	}
}