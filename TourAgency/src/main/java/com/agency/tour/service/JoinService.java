package com.agency.tour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agency.tour.domain.LoginUser;
import com.agency.tour.domain.Role;
import com.agency.tour.global.ResponseCode;
import com.agency.tour.repository.MemberRepository;
import com.agency.tour.request.JoinRequestDto;

@Service
public class JoinService {
	@Autowired
	private MemberRepository mRepo;
	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	public ResponseCode join(JoinRequestDto dto) {
		LoginUser user = LoginUser.builder()
							.loginId(dto.getLoginId())
							.pwd(bCryptPasswordEncoder.encode(dto.getPwd()))
							.email(dto.getEmail())
							.name(dto.getName())
							.isLock(dto.getIsLock())
							.role(dto.getRole())
							.birth(dto.getBirth())
							.sex(dto.getSex())
							.phone(dto.getPhone())
							.build();
		mRepo.save(user);
		System.out.println(user);
		return ResponseCode.OK;
	}
}
