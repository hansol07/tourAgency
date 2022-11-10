package com.agency.tour.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.domain.GuideVo;
import com.agency.tour.global.ActiveEnum;
import com.agency.tour.repository.GuideRepository;
import com.agency.tour.response.GuideResponseDto;

@Service
public class GuideService {
	@Autowired
	private GuideRepository gRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	public List<GuideResponseDto> getGuideList(){
		List<GuideVo> guideVoList = gRepo.findAllByIsActive(ActiveEnum.Y.toString());
		List<GuideResponseDto> guideResponseList = guideVoList.stream().map(guideVo ->modelMapper.map(guideVo, GuideResponseDto.class)).toList();
		return guideResponseList;
	}
}
