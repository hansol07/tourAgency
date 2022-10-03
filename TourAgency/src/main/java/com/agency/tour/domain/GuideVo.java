package com.agency.tour.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String phone;
	@NotBlank
	private String introduce;
	private String isActive;
    @CreationTimestamp
    private Timestamp regDt;
    @UpdateTimestamp
    private Timestamp updDt;
    private String updateId;
    private String createId;
    
}
