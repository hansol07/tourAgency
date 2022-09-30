package com.agency.tour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.tour.repository.GuideRepository;

@Service
public class GuideService {
	@Autowired
	private GuideRepository gRepo;
}
