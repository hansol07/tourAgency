package com.agency.tour.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class LoginUser {
	
	@Id
    private String loginId;
    private String pwd;
    private String name;
    private String email;
    private String role;	//ROLE_USER , ROLE_ADMIN
    @CreationTimestamp
    private Timestamp regDt;
    @UpdateTimestamp
    private Timestamp updDt;
    private String regrId;
    private String updrId;
    private boolean islock=false;

}
