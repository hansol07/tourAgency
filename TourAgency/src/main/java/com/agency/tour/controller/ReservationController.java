package com.agency.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.agency.tour.domain.Member;
import com.agency.tour.requestDto.TourReservationRequestDto;
import com.agency.tour.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/tour/reservation")
	public String reservationTour(TourReservationRequestDto dto, @AuthenticationPrincipal Member member) {
		reservationService.reservationTour(dto, member);
		return "redirect:/tour/";
	}
	@GetMapping("/tour/reservation")
	public String reservationList(@AuthenticationPrincipal Member member, Model model) {
		model.addAttribute("list",reservationService.findMyReservation(member));
		return "/reservation/myreservationList";
	}
	@GetMapping("/tour/reservation/cancel/{id}")
	public String deleteReservation(@AuthenticationPrincipal Member member, @PathVariable String id) {
		reservationService.cancelReservation(member,id);
		return "redirect:/tour/reservation";
	}
}
