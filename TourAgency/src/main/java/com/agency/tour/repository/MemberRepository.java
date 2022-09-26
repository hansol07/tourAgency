package com.agency.tour.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agency.tour.domain.LoginUser;

@Repository
public interface MemberRepository extends JpaRepository<LoginUser, String> {

}
