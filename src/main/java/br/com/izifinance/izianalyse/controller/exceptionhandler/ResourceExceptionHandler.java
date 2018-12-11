package br.com.izifinance.izianalyse.controller.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.izifinance.izianalyse.exception.ObjectNotFoundException;
import br.com.izifinance.izianalyse.exception.OperationNotAllowedException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;

		StandardError error = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Not Found!",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(httpStatus).body(error);
	}
	
	@ExceptionHandler(OperationNotAllowedException.class)
	public ResponseEntity<StandardError> operationNotAllowedException(OperationNotAllowedException e, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;

		StandardError error = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Not Found!",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(httpStatus).body(error);
	}

	
}
