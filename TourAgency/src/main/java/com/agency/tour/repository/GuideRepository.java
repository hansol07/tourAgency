package com.agency.tour.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agency.tour.domain.GuideVo;

@Repository
public interface GuideRepository extends JpaRepository<GuideVo, Long> {

}
