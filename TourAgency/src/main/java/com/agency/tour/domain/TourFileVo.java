package com.agency.tour.domain;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@SequenceGenerator(name="TourFile_SEQ_GENERATOR",sequenceName = "TourFile_SEQ" ,initialValue = 1,allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class TourFileVo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "TourFile_SEQ_GENERATOR")
	private long id;
	private String filePath;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TourVo tourVo;
	
    private String isActive;
    private String updateId;
    private String createId;
}
