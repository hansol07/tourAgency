package com.agency.tour.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuideRequestDto {

	private String name;
	private String email;
	private String phone;
	private String introduce;
}
