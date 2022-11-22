package com.agency.tour.service;

import java.util.List;

import javax.transaction.Transactional;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.domain.Member;
import com.agency.tour.domain.ReservationVo;
import com.agency.tour.domain.TourVo;
import com.agency.tour.global.ActiveEnum;
import com.agency.tour.global.ReservationStatus;
import com.agency.tour.global.ResponseCode;
import com.agency.tour.repository.ReservationRepository;
import com.agency.tour.repository.TourRepository;
import com.agency.tour.request.TourReservationRequestDto;
import com.agency.tour.response.ReservationListResponseDto;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private TourRepository tourRespository;
	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public ResponseCode reservationTour(TourReservationRequestDto dto, Member member) {
		ReservationVo reservation = ReservationVo.builder()
				.countPeople(dto.getCountPeople())
				.tourVo(tourRespository.findById(dto.getTourId()).orElse(null))
				.requireMent(dto.getRequireMent())
				.reservationStatus(ReservationStatus.APPLY.toString())
				.userId(member.getId())
				.isActive(ActiveEnum.Y.toString())
				.createId(member.getId())
				.updateId(member.getId())
				.build();
		reservationRepository.save(reservation);
		currentPeoplePlus(dto.getTourId(), dto.getCountPeople());
		return ResponseCode.OK;
	}
	public ResponseCode currentPeoplePlus(long id, int plusPeople) {
		TourVo vo=tourRespository.findById(id).orElse(null);
		vo.setCurrentPeople(vo.getCurrentPeople()+plusPeople);
		tourRespository.save(vo);
		return ResponseCode.OK;
	}
	public 	List<ReservationListResponseDto> findMyReservation(Member member) {
		List<ReservationVo> voList = reservationRepository.findAllByUserIdAndIsActive(member.getId(),ActiveEnum.Y.toString());
		List<ReservationListResponseDto> list = voList.stream().map(reservationVo ->modelMapper.map(reservationVo,ReservationListResponseDto.class)).toList();
		return list;
	}

	public ResponseCode cancelReservation(Member member, String id) {
		ReservationVo reservation=reservationRepository.findById(Long.parseLong(id)).orElse(null);
		reservation.setIsActive(ActiveEnum.N.toString());
		reservation.setUpdateId(member.getId());
		reservationRepository.save(reservation);
		return ResponseCode.OK;
	}
}
