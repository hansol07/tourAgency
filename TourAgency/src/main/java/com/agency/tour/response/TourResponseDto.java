package com.agency.tour.response;

import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
public class TourResponseDto {
	
	private long id;
	private String title;
	private Date startDate;
	private Date endDate;
	private int currentPeople;
}
