package com.agency.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.domain.TourVo;
import com.agency.tour.dto.TourDto;
import com.agency.tour.global.ActiveEnum;
import com.agency.tour.global.ResponseCode;
import com.agency.tour.repository.TourRepository;

@Service
public class TourService {

	@Autowired
	private TourRepository tourRepository;
	
	public ResponseCode registerTour(TourDto dto,long id) {
		TourVo tour= TourVo.builder()
						.title(dto.getTitle())
						.introduce(dto.getIntroduce())
						.price(dto.getPrice())
						.startDate(dto.getStartDate())
						.endDate(dto.getEndDate())
						.maximunNum(dto.getMaximunNum())
						.minimunNum(dto.getMinimunNum())
						.isOneday(dto.getIsOneday())
						.notIncludeContents(dto.getNotIncludeContents())
						.includeContents(dto.getIncludeContents())
						.course(dto.getCourse())
						.timeInformation(dto.getTimeInformation())
						.isActive(ActiveEnum.Y.toString())
						.endReservationDay(dto.getEndReservationDay())
						.currentPeople(0)
						.createId(id)
						.updateId(id)
						.build();
		tourRepository.save(tour);
		return ResponseCode.OK;
	}
	
	public List<TourVo> getTourList() {
		return tourRepository.findAllByIsActive(ActiveEnum.Y.toString());	
	}
}
