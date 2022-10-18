package com.agency.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agency.tour.domain.ReservationVo;

public interface ReservationRepository extends JpaRepository<ReservationVo, Long> {

	List<ReservationVo> findAllByUserIdAndIsActive(long id, String active);

}
