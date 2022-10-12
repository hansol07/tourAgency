package com.agency.tour.domain;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
@Data
@EqualsAndHashCode(of = "loginId")

public class Member implements UserDetails {

    private static final long serialVersionUID = 174726374856727L;

    private LoginUser user;

    public Member(LoginUser user) {
        this.user = user;
    }

    /**
     * 해당 유저의 권한 목록
     */
    //해당 User의 권한을 리턴하는 곳!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collection;
    }


    /**
     * 비밀번호
     */
    @Override
    public String getPassword() {
        return this.user.getPwd();
    }


    /**
     * PK값
     */
    @Override
    public String getUsername() {
        return this.user.getLoginId();
    }

    public long getId() {
    	return this.user.getId();
    }


    public String getEmail(){
    	return this.user.getEmail();
    }

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}