package com.agency.tour.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@SequenceGenerator(name="Review_SEQ_GENERATOR",sequenceName = "Review_SEQ" ,initialValue = 1,allocationSize = 1)
@NoArgsConstructor
public class ReviewVo extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "Review_SEQ_GENERATOR")
	private long id;
	private long loginId;
	private int score;
	private String contents;
	
	private long reservationId;
	
	private String isActive;
    private long updateId;
    private long createId;
}
