package com.agency.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.agency.tour.domain.Member;
import com.agency.tour.requestDto.TourRequestDto;
import com.agency.tour.service.TourService;

@Controller
public class TourController {

	@Autowired
	private TourService tourService;

	@GetMapping("/tour/register")
	public String tourRegister() {
		return "tour/tourRegister";
	}
	@GetMapping("/tour")
	public String tour(Model model) {
		model.addAttribute("list",tourService.getTourList());
		return "tour/tourList";
	}
	@PostMapping("/tour/register")
	public String joinForm(TourRequestDto dto, @AuthenticationPrincipal Member member) {
		tourService.registerTour(dto,member.getId());
		return "redirect:/";
	}
	@GetMapping("/tour/detail/{id}")
	public String tourDetail(@PathVariable String id, Model model) {
		model.addAttribute("list",tourService.getTourDetailList(id));
		return "tour/tourDetail";
	}
	@GetMapping("/tour/deleteTour/{id}")
	public String deleteTour(@AuthenticationPrincipal Member member, @PathVariable String id) {
		tourService.deleteTour(member, id);
		return "redirect:/tour/";
	}
}
