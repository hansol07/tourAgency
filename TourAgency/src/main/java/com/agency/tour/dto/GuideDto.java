package com.agency.tour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuideDto {

	private String name;
	private String email;
	private String phone;
	private String introduce;
}
