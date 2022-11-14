package com.agency.tour.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.domain.GuideVo;
import com.agency.tour.domain.Member;
import com.agency.tour.global.ActiveEnum;
import com.agency.tour.global.ResponseCode;
import com.agency.tour.repository.GuideRepository;
import com.agency.tour.request.GuideRequestDto;
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
	public ResponseCode insertGuide(GuideRequestDto dto , Member member) {
		GuideVo guideVo = GuideVo.builder()
						.name(dto.getName())
						.email(dto.getEmail())
						.phone(dto.getPhone())
						.introduce(dto.getIntroduce())
						.isActive(ActiveEnum.Y.toString())
						.createId(member.getId())
						.updateId(member.getId())
						.build();
		gRepo.save(guideVo);
		return ResponseCode.OK;
	}
}
