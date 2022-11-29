package com.agency.tour.request;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.agency.tour.domain.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequestDto {

	@NotBlank
	@Pattern(regexp="[a-zA-Z1-9]{3,10}", message = "아이디는 영어와 숫자로 포함해서 3~10자리 이내로 입력해주세요.")
	private String loginId;
	@NotBlank
	@Pattern(regexp="[a-zA-Z1-9]{3,12}", message = "비밀번호는 영어와 숫자로 포함해서 3~12자리 이내로 입력해주세요.")
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
