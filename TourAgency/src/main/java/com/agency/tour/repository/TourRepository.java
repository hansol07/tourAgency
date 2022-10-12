package com.agency.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agency.tour.domain.TourVo;

public interface TourRepository extends JpaRepository<TourVo, Long>{

	public List<TourVo> findAllByIsActive(String active);
}
