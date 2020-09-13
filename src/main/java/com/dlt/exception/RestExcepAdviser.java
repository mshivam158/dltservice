package com.dlt.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExcepAdviser {
	private ResponseEntity<Object> buildResponse(int status, Exception e, boolean isError) {
		return ResponseEntity.status(status).body(new ApiError(status, e.getMessage(), isError));
	}

	@ExceptionHandler({ RestException.class })
	public ResponseEntity<Object> handle(RestException e) {
		return this.buildResponse(e.getStatus(), e, e.isError());
	}
}
