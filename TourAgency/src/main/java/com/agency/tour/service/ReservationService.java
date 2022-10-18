package com.agency.tour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.domain.Member;
import com.agency.tour.domain.ReservationVo;
import com.agency.tour.dto.TourReservationDto;
import com.agency.tour.global.ActiveEnum;
import com.agency.tour.global.ReservationStatus;
import com.agency.tour.global.ResponseCode;
import com.agency.tour.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	public ResponseCode reservationTour(TourReservationDto dto, Member member) {
		ReservationVo reservation = ReservationVo.builder()
										.countPeople(dto.getCountPeople())
										.tourId(dto.getTourId())
										.requireMent(dto.getRequireMent())
										.reservationStatus(ReservationStatus.APPLY.toString())
										.userId(member.getId())
										.isActive(ActiveEnum.Y.toString())
										.createId(member.getId())
										.updateId(member.getId())
										.build();
		reservationRepository.save(reservation);
		return ResponseCode.OK;
	}
}
