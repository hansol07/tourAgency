package com.agency.tour.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuideRequestDto {

	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String phone;
	private String introduce;
}
