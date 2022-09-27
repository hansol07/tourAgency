package com.agency.tour.global;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum ResponseCode {

	OK(0, HttpStatus.OK, "Ok"),	//성공

	BAD_REQUEST(10000, HttpStatus.BAD_REQUEST, "Bad request"),		//잘못된 request
	VALIDATION_ERROR(10001, HttpStatus.BAD_REQUEST, "Validation error"),	// 유효성 검사 오류
	NOT_FOUND(10002, HttpStatus.NOT_FOUND, "Requested resource is not found"), //notfound

	INTERNAL_ERROR(20000, HttpStatus.INTERNAL_SERVER_ERROR, "Internal error"),		
	DATA_ACCESS_ERROR(20001, HttpStatus.INTERNAL_SERVER_ERROR, "Data access error"),

	UNAUTHORIZED(40000, HttpStatus.UNAUTHORIZED, "User unauthorized");


	ResponseCode(int i, HttpStatus badRequest, String string) {
		// TODO Auto-generated constructor stub
	}

}
