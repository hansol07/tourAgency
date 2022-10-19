package com.agency.tour.domain;


import javax.persistence.Entity;
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
@AllArgsConstructor
@SequenceGenerator(name="Reservation_SEQ_GENERATOR",sequenceName = "Reservation_SEQ" ,initialValue = 1,allocationSize = 1)
@NoArgsConstructor
public class ReservationVo extends BaseEntity{

	
	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "Reservation_SEQ_GENERATOR")
	private long id;
	private int countPeople;
	private long userId;
	private String reservationStatus;
	
	@ManyToOne
	private TourVo tourVo;
	private String requireMent;

	   
	private String isActive;
    private long updateId;
    private long createId;
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public void setUpdateId(long updateId) {
		this.updateId = updateId;
	}
	
    
}
