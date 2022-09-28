package com.agency.tour.dto;

import com.agency.tour.domain.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDto {

	private String loginId;
	private String pwd;
	private String email;
	private String name;
	private final String role =Role.ROLE_USER.toString();
	private final String isLock="N";
	@Override
	public String toString() {
		return "JoinDto [loginId=" + loginId + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", role=" + role
				+ ", isLock=" + isLock + "]";
	}

	
}
