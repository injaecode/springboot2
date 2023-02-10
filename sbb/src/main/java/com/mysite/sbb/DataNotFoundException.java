package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//사용자가 생성한 예외
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="요청 레코드를 못찾았음")

public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException (String message) {
		super(message);
	}
}
