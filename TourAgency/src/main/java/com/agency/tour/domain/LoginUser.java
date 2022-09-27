package com.agency.tour.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
    private String role;	//ROLE_USER , ROLE_ADMIN
    @CreationTimestamp
    private Timestamp regDt;
    @UpdateTimestamp
    private Timestamp updDt;
    private String isLock;

    @Override
	public String toString() {
		return "LoginUser [loginId=" + loginId + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", role="
				+ role + ", regDt=" + regDt + ", updDt=" + updDt + ", islock=" + isLock + "]";
	}
	
 

    
    
}
