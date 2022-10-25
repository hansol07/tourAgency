package com.agency.tour.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@SequenceGenerator(name="Guide_SEQ_GENERATOR",sequenceName = "Guide_SEQ" ,initialValue = 1,allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class GuideVo extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "Guide_SEQ_GENERATOR")
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	private String introduce;
 
	private String isActive;
    private long updateId;
    private long createId;
    
    
    @OneToMany(mappedBy = "guide", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<GuideFileVo> guideFileVo = new ArrayList<>();
}
