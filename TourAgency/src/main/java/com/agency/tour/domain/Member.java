package com.agency.tour.domain;



import java.io.Serializable;
import java.util.*;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.agency.tour.dto.LoginUserDto;

import lombok.EqualsAndHashCode;
@EqualsAndHashCode(of = "loginId")
public class Member implements UserDetails {

    private static final long serialVersionUID = 174726374856727L;

    private String loginId;		// 로그인용 ID 값, gksthf07
    private String password;	// 비밀번호
    private String email;	//이메일
    private String name;	//이름
    private boolean locked = true;	//계정 잠김 여부

    private Collection<GrantedAuthority> authorities;	//권한 목록


    /**
     * 해당 유저의 권한 목록
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setRole(Collection<? extends GrantedAuthority> authorities){
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per
        // UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(new AuthorityComparator());
        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }
        return sortedAuthorities;
    }


    /**
     * 비밀번호
     */
    @Override
    public String getPassword() {
        return password;
    }


    /**
     * PK값
     */
    @Override
    public String getUsername() {
        return loginId;
    }


    public String getMbrNm() {
    	return  name;
    }



    public String getEmail(){return email;}





    public Member(LoginUserDto loginUserDto) {
        //Assert.isTrue(loginUserDto.getLoginId() != null && !"".equals(loginUserDto.getLoginId()) && password != null, "Cannot pass null or empty values to constructor");
        this.loginId = loginUserDto.getLoginId();
        this.password = loginUserDto.getPwd();
        this.name = loginUserDto.getName();
        this.email = loginUserDto.getEmail();
    }

    /** 인증된 사용자 **/
    public static Member creatAuthorizedMember(LoginUserDto loginUserDto){
        Member member = new Member(loginUserDto);
        member.authorities = setRole("ROLE_USER");
        return member;
    }

    /**
     * 권한 설정
     * @param role
     * @return
     */
    private static List<GrantedAuthority> setRole(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }




    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {

        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        @Override
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to
            // the set. If the authority is null, it is a custom authority and should
            // precede others.
            if (g2.getAuthority() == null) {
                return -1;
            }
            if (g1.getAuthority() == null) {
                return 1;
            }
            return g1.getAuthority().compareTo(g2.getAuthority());
        }

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