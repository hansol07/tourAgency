package com.agency.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.domain.Member;
import com.agency.tour.domain.ReservationVo;
import com.agency.tour.global.ActiveEnum;
import com.agency.tour.global.ReservationStatus;
import com.agency.tour.global.ResponseCode;
import com.agency.tour.repository.ReservationRepository;
import com.agency.tour.repository.TourRepository;
import com.agency.tour.requestDto.TourReservationRequestDto;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private TourRepository tourRespository;
	
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
		return ResponseCode.OK;
	}

	public List<ReservationVo> findMyReservation(Member member) {
		return reservationRepository.findAllByUserIdAndIsActive(member.getId(),ActiveEnum.Y.toString());
	}

	public ResponseCode cancelReservation(Member member, String id) {
		ReservationVo reservation=reservationRepository.findById(Long.parseLong(id)).orElse(null);
		reservation.setIsActive(ActiveEnum.N.toString());
		reservation.setUpdateId(member.getId());
		reservationRepository.save(reservation);
		return ResponseCode.OK;
	}
}
