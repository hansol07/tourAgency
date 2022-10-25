package com.agency.tour.requestDto;

import java.sql.Date;

import com.agency.tour.global.ReservationStatus;

import lombok.Data;

@Data
public class TourReservationRequestDto {

	private int countPeople;
	private String requireMent;
	private Long tourId;
}
