package com.agency.tour.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.config.ModelMapperConfig;
import com.agency.tour.domain.Member;

import com.agency.tour.domain.TourVo;
import com.agency.tour.global.ActiveEnum;
import com.agency.tour.global.ResponseCode;
import com.agency.tour.repository.TourRepository;
import com.agency.tour.request.TourRequestDto;
import com.agency.tour.response.TourDetailResponseDto;
import com.agency.tour.response.TourListResponseDto;

@Service
public class TourService {

	@Autowired
	private TourRepository tourRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseCode registerTour(TourRequestDto dto,long id) {
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
	
	public List<TourListResponseDto> getTourList() {
		List<TourVo> tourVoList= tourRepository.findAllByIsActive(ActiveEnum.Y.toString());	
		List<TourListResponseDto> tourList = tourVoList.stream().map(tourVo ->modelMapper.map(tourVo, TourListResponseDto.class)).collect(Collectors.toList());
		System.out.println(tourList);
		return tourList;
	}
	public TourDetailResponseDto getTourDetailList(String id) {
		long tourId = Long.parseLong(id);
		TourVo tour = tourRepository.findById(tourId).orElse(null);
		TourDetailResponseDto tourResponsedto = modelMapper.map(tour, TourDetailResponseDto.class);
		return tourResponsedto;
	}
	public ResponseCode deleteTour(Member member, String id) {
		TourVo tour=tourRepository.findById(Long.parseLong(id)).orElse(null);
		tour.setIsActive(ActiveEnum.N.toString());
		tour.setUpdateId(member.getId());
		tourRepository.save(tour);
		return ResponseCode.OK;
	}
}

