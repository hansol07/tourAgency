package com.agency.tour.domain;

import java.sql.Date;
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
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

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
	@NotBlank
	private String title;
	@NotBlank
	private String introduce;
	
	@Min(value=0)
	@NotBlank
	private int price;
	
	@Future
	@NotBlank
	private Date startDate;
	@Future
	private Date endDate;
	@FutureOrPresent
	@NotBlank
	private Date endReservationDay;
	
	@NotBlank
	@Min(value=0)
	private int maximunNum;
	@Min(value=0)
	@NotBlank
	private int minimunNum;
	
	@NotNull
	private String isOneday;
	
	private String includeContents;
	private String notIncludeContents;
	private String course;
	private String timeInformation;
	private int currentPeople;
	
	@OneToMany(mappedBy = "tourVo", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<TourFileVo> tourFileList = new ArrayList<>();
	
	private String isActive;
    private long updateId;
    private long createId;
	
    
    public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public void setUpdateId(long updateId) {
		this.updateId = updateId;
	}
	
	
}
