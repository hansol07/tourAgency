package com.agency.tour.config;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.agency.tour.config.exception.NoMemberException;
import com.agency.tour.domain.Member;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {


    private final UserDetailsService customUserDetailsService;

    private final BCryptPasswordEncoder passwordEncoder;




    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication == null){
            throw new InternalAuthenticationServiceException("인증 정보가 없습니다");
        }
        String username = authentication.getName();
        if(authentication.getCredentials() == null){
            throw new AuthenticationCredentialsNotFoundException("Credentials이 없습니다");
        }
        String password = authentication.getCredentials().toString();
        try {
            /* 사용자 정보 받기 */
            Member loadedUser = (Member) customUserDetailsService.loadUserByUsername(username);
            if (loadedUser == null) {
                throw new InternalAuthenticationServiceException("유저정보가 입력되지않았습니다");
            }
      
            /** 실질적인 인증 시작 **/
            if (!passwordEncoder.matches(password, loadedUser.getPassword())) {
            	 throw new BadCredentialsException("아이디나 비밀번호가 올바르지 않습니다.");
            }
            /** 인증 성공 **/
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(loadedUser, null, loadedUser.getAuthorities());
            result.setDetails(authentication.getDetails());
            return result;
        }catch (NoMemberException e){
            throw new NoMemberException("해당 아이디는 없습니다");
        }
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
