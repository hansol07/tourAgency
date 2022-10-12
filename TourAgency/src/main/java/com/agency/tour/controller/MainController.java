package com.agency.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.agency.tour.domain.Member;
import com.agency.tour.dto.JoinDto;
import com.agency.tour.service.JoinService;
@Controller
public class MainController {
	@Autowired
	private JoinService jService;
	@GetMapping("/")
	public String main(@AuthenticationPrincipal Member member) {
		System.out.println(member.getId()+member.getEmail());
		return "index";
	}
	@GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/join")
    public String join() {
        return "join";
    }
    @PostMapping("/join")
    public String joinForm(JoinDto dto) {
    	jService.join(dto);
    	return "redirect:/";
    }
   
}
