package com.agency.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agency.tour.domain.ReservationVo;

public interface ReservationRepository extends JpaRepository<ReservationVo, Long> {

}
