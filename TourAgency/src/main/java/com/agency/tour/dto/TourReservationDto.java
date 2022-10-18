package com.agency.tour.dto;

import java.sql.Date;

import com.agency.tour.global.ReservationStatus;

import lombok.Data;

@Data
public class TourReservationDto {

	private int countPeople;
	private String requireMent;
	private Long tourId;
}
