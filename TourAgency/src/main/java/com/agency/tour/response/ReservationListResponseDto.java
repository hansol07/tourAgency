package com.agency.tour.response;


import com.agency.tour.domain.TourVo;

import lombok.Data;

@Data
public class ReservationListResponseDto {

	
	private long id;
	private int countPeople;
	private long userId;
	private String reservationStatus;
	private TourVo tourVo;
	private String requireMent;
}
