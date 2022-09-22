package com.agency.tour.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginUserDto {

    private int loginSeq;
    private String loginId;
    private String pwd;
    private String name;
    private String email;
    private Date regDt;
    private Date updDt;
    private String regrId;
    private String updrId;

}
