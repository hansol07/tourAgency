package com.agency.tour.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Entity
@Builder
@SequenceGenerator(name="GuideFile_SEQ_GENERATOR",sequenceName = "GuideFile_SEQ" ,initialValue = 1,allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class GuideFileVo extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "GuideFile_SEQ_GENERATOR")
	private long id;
	private String filePath;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private GuideVo guide;
	
    private String isActive;
    private long updateId;
    private long createId;
}
