package com.agency.tour.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.agency.tour.config.exception.*;
import com.agency.tour.domain.LoginUser;
import com.agency.tour.domain.Member;
import com.agency.tour.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final MemberRepository memberRepository;



    @Override
    public UserDetails loadUserByUsername(String loginId) {

    	LoginUser user= memberRepository.findByLoginId(loginId).orElseThrow(() -> new NoMemberException());
    
        return new Member(user);
    }

  
}
