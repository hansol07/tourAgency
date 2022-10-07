package com.agency.tour.domain;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@SequenceGenerator(name="Tour_SEQ_GENERATOR",sequenceName = "Tour_SEQ" ,initialValue = 1,allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class TourVo extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "Tour_SEQ_GENERATOR")
	private long id;
	private String title;
	private String introduce;
	private String price;
	private Date startDate;
	private Date endDate;
	private String isOneday;
	private String includeContents;
	private String notIncludeContents;
	private String course;
	private String timeInformation;
	
	@OneToMany(mappedBy = "tourVo", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<TourFileVo> tourFileList = new ArrayList<>();
	
	private String isActive;
    private String updateId;
    private String createId;
	
	
}
