package com.agency.tour.request;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.agency.tour.domain.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequestDto {

	@NotBlank
	private String loginId;
	@NotBlank
	private String pwd;
    @NotBlank
    @Email
	private String email;
	private String phone;
	private Date birth;
	private String sex;
	@NotBlank
	private String name;
	private final String role =Role.ROLE_USER.toString();
	private final String isLock="N";
	@Override
	public String toString() {
		return "JoinDto [loginId=" + loginId + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", role=" + role
				+ ", isLock=" + isLock + "]";
	}

	
}
