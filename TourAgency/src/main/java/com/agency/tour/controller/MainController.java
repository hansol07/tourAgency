package com.agency.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.agency.tour.domain.Member;
import com.agency.tour.request.JoinRequestDto;
import com.agency.tour.service.JoinService;
import com.agency.tour.service.LottoService;
@Controller
public class MainController {
	@Autowired
	private JoinService jService;
	@Autowired
	private LottoService lottoService;
	@GetMapping("/")
	public String main(@AuthenticationPrincipal Member member, Model model) {
		model.addAttribute("lottoList",lottoService.makeLottoNum());
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
    public String joinForm(JoinRequestDto dto) {
    	jService.join(dto);
    	return "redirect:/";
    }
    @GetMapping("/lotto/lotto")
    public String lotto() {
    	return "/lotto/lotto";
    }
   
}
