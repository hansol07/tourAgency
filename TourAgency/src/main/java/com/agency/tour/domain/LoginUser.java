package com.agency.tour.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Builder
@AllArgsConstructor
@SequenceGenerator(name="LoginUser_SEQ_GENERATOR",sequenceName = "LoginUser_SEQ" ,initialValue = 1,allocationSize = 1)
@NoArgsConstructor
public class LoginUser extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "LoginUser_SEQ_GENERATOR")
	private long id;
    private String loginId;
	private String pwd;
  
    private String name;

    private String email;
    private String role;	//ROLE_USER , ROLE_ADMIN
    
	private String phone;
	private Date birth;
	private String sex;
  
    private String isLock;
    private String isActive;
	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", loginId=" + loginId + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", role=" + role + ", phone=" + phone + ", birth=" + birth + ", sex=" + sex + ", isLock=" + isLock
				+ ", isActive=" + isActive + "]";
	}
	 
}
