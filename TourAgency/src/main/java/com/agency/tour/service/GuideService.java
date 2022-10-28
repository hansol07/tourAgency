package com.agency.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.domain.GuideVo;
import com.agency.tour.global.ActiveEnum;
import com.agency.tour.repository.GuideRepository;

@Service
public class GuideService {
	@Autowired
	private GuideRepository gRepo;
	
	public List<GuideVo> getGuideList(){
		return gRepo.findAllByIsActive(ActiveEnum.Y.toString());
	}
}
