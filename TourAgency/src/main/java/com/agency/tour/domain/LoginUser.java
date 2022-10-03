package com.agency.tour.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
	
	@Id
	@NotBlank
    private String loginId;
    @NotBlank
	private String pwd;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String role;	//ROLE_USER , ROLE_ADMIN
	private String phone;
	private Date birth;
	private String sex;
    @CreationTimestamp
    private Timestamp regDt;
    @UpdateTimestamp
    private Timestamp updDt;
    private String isLock;
    private String isActive;
	@Override
	public String toString() {
		return "LoginUser [loginId=" + loginId + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", role="
				+ role + ", phone=" + phone + ", birth=" + birth + ", sex=" + sex + ", regDt=" + regDt + ", updDt="
				+ updDt + ", isLock=" + isLock + "]";
	}


	
 

    
    
}
