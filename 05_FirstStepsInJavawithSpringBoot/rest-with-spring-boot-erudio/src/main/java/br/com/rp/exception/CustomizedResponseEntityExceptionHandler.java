package br.com.rp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionsResponse> handleAllExceptionEntity(
			Exception ex, WebRequest request) {
		
		ExceptionsResponse exceptionsResponse = new ExceptionsResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
				
		return new ResponseEntity<>(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedMathOperationException.class)
	
	public final ResponseEntity<ExceptionsResponse> handleBadRequestException(
			Exception ex, WebRequest request) {
		
		ExceptionsResponse exceptionsResponse = new ExceptionsResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
				
		return new ResponseEntity<>(exceptionsResponse, HttpStatus.BAD_REQUEST);
	}

}
