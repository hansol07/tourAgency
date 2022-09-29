package com.agency.tour.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuideVo {

	@Id
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String introduce;
	private String isLock;
    @CreationTimestamp
    private Timestamp regDt;
    @UpdateTimestamp
    private Timestamp updDt;
    private String updateId;
    private String createId;
    
}
