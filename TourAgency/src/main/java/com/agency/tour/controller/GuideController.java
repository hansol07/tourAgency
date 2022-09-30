package com.agency.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.agency.tour.service.GuideService;

@Controller
public class GuideController {

	@Autowired
	private GuideService gService;
}
