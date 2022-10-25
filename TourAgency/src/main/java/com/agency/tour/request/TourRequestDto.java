package com.agency.tour.request;

import java.sql.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;


@Data
public class TourRequestDto {

	@NotBlank
	private String title;
	@NotBlank
	private String introduce;
	@Min(value=0)
	@NotBlank
	private int price;
	@Future
	@NotBlank
	private Date startDate;
	@Future
	private Date endDate;
	@FutureOrPresent
	@NotBlank
	private Date endReservationDay;
	@NotBlank
	@Min(value=0)
	private int maximunNum;
	@NotBlank
	@Min(value=0)
	private int minimunNum;
	@NotNull
	private String isOneday;
	private String includeContents;
	private String notIncludeContents;
	private String course;
	private String timeInformation;
}
