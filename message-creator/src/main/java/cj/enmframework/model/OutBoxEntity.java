package cj.enmframework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 8.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 8. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Getter
@Entity
@Table(name = "outbox")
public class OutBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String topic;
    @Column(columnDefinition="TEXT")
    private String payload;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public OutBoxEntity(String topic, String payload, Status status) {
    	this.topic = topic;
    	this.payload = payload;
    	this.status = status;
    }
    
    @AllArgsConstructor
	public enum Status {
		OPEN("MQ처리대상"), CLOSE("MQ처리완료");
		
		private String description;
		
		public String getDescription() {
			return this.description;
		}
	}
	
	public void changeToCloseStatus() {
		this.status = Status.CLOSE;
	}
	public void changeToOpenStatus() {
		this.status = Status.OPEN;
	}
}