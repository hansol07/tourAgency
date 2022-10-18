package com.agency.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.agency.tour.domain.Member;
import com.agency.tour.dto.TourReservationDto;
import com.agency.tour.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/tour/reservation")
	public String reservationTour(TourReservationDto dto, @AuthenticationPrincipal Member member) {
		reservationService.reservationTour(dto, member);
		return "redirect:/tour/";
	}
}
