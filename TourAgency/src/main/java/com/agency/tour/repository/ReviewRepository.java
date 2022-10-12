package com.agency.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agency.tour.domain.ReviewVo;

public interface ReviewRepository extends JpaRepository<ReviewVo, Long> {

}
