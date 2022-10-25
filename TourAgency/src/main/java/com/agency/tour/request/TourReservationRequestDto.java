package com.agency.tour.request;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.agency.tour.global.ReservationStatus;

import lombok.Data;

@Data
public class TourReservationRequestDto {

	@NotBlank
	@Min(value=0)
	private int countPeople;
	private String requireMent;
	private Long tourId;
}
