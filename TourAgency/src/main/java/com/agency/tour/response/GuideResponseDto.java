package com.agency.tour.response;

import java.util.ArrayList;
import java.util.List;

import com.agency.tour.domain.GuideFileVo;

import lombok.Data;

@Data
public class GuideResponseDto {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String introduce;
	private List<GuideFileVo> guideFileVo = new ArrayList<>();
}
