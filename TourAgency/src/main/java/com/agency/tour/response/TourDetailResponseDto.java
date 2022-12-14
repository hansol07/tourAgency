package com.agency.tour.response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.agency.tour.domain.TourFileVo;

import lombok.Data;

@Data
public class TourDetailResponseDto {

    private long id;
	private String title;
	private String introduce;
	private int price;
	private Date startDate;
	private Date endDate;
	private Date endReservationDay;
	private int maximunNum;
	private int minimunNum;
	private String isOneday;
	private String includeContents;
	private String notIncludeContents;
	private String course;
	private String timeInformation;
	private int currentPeople;
	private List<TourFileVo> tourFileList = new ArrayList<>();
}
