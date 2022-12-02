package com.agency.tour.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuideRequestDto {

	@NotBlank
	@Pattern(regexp="[a-zA-Z가-힣]{1,15}", message = "올바른 이름을 입력해 주세요.")
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Pattern(regexp="[0-9]{9,11}", message = "올바른 전화번호를 입력해 주세요.")
	private String phone;
	private String introduce;
}
