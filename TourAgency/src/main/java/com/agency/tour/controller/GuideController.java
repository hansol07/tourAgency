package com.agency.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.agency.tour.domain.Member;
import com.agency.tour.request.GuideRequestDto;
import com.agency.tour.service.GuideService;

@Controller
public class GuideController {

	@Autowired
	private GuideService guideService;
	
	@GetMapping("/guide/list")
	public String guideList(Model model) {
		model.addAttribute("list",guideService.getGuideList());
		return "/guide/list";
	}
    @GetMapping("/guide/register")
    public String guideRegisterPage() {
    	return "/guide/guideRegister";
    }
    @PostMapping("/guide/register")
    public String guideRegister(GuideRequestDto dto, @AuthenticationPrincipal Member member) {
    	guideService.insertGuide(dto, member);
    	return "redirect:/guide/list";
    }
}
