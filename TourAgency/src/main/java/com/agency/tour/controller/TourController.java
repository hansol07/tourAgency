package com.agency.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.agency.tour.domain.Member;
import com.agency.tour.dto.TourDto;
import com.agency.tour.service.TourService;

@Controller
public class TourController {

	@Autowired
	private TourService tourService;
	
	 @GetMapping("/tour/register")
	    public String tourRegister() {
	        return "tour/tourRegister";
	    }
	 @GetMapping("/tour/")
	 public String tour(Model model) {
		 System.out.println(tourService.getTourList());
		 model.addAttribute("list",tourService.getTourList());
		 return "tour/tourList";
	 }
	    @PostMapping("/tour/register")
	    public String joinForm(TourDto dto,@AuthenticationPrincipal Member member) {
	    	tourService.registerTour(dto,member.getId());
	    	return "redirect:/";
	    }
}
