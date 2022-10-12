package com.agency.tour.domain;


import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@SequenceGenerator(name="Reservation_SEQ_GENERATOR",sequenceName = "Reservation_SEQ" ,initialValue = 1,allocationSize = 1)
@NoArgsConstructor
public class ReservationVo extends BaseEntity{

	
	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "Reservation_SEQ_GENERATOR")
	private long id;
	private int countPeople;
	private long userId;
	private String reservationStatus;
	private long tourId;
	private String requireMent;
	
    @OneToOne(mappedBy = "reservationVo", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ReviewVo reviewVo;
	
    
	private String isActive;
    private long updateId;
    private long createId;
	
}
