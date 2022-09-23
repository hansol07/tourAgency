package com.agency.tour.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.agency.tour.config.exception.*;
import com.agency.tour.domain.Member;
import com.agency.tour.dto.LoginUserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final LoginRepository loginRepository;
    private final ApiService apiService;
    private final Integer MAX_FAIL = 5;


    public Optional<LoginUser> findById(String loginId){
        return loginRepository.findById(loginId);
    }


    public LoginUserDto findUserByLoginId(String loginId){
        LoginUser loginUser = loginRepository.findUserByLoginId(loginId).orElseThrow(NoMemberException::new);
        return LoginUserDto.from(loginUser);
    }
    /**
     * <h3>사용자가 입력한 ID값에 따라 DB에서 사용자 정보(={@link Member}) 출력</h3>
     * @param loginId the username identifying the user whose data is required.
     * @see CustomAuthenticationProvider#authenticate(Authentication)
     * @throws UsernameNotFoundException
     * @author 김찬영
     */
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {


        LoginUserDto loginUserDto = this.findUserByLoginId(loginId);
        Member member = isNoAuthorizedMember(loginUserDto);

        return member;
    }

  
}
