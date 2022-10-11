package com.agency.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agency.tour.domain.TourVo;

public interface TourRepository extends JpaRepository<TourVo, Long>{

}
