package mooqaf.exceptions;

import java.util.Date;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import mooqaf.response.ResponseMessage;

@ControllerAdvice
public class AppExceptionHndler {
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handlAnyException(Exception ex,WebRequest request){
		String errorMessageDescription =ex.getLocalizedMessage();
		if(errorMessageDescription == null ) errorMessageDescription=ex.toString();
		ResponseMessage errorMessage =new ResponseMessage(new Date(),errorMessageDescription);
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value= {NoSuchElementException.class})
	public ResponseEntity<Object> handlNoSuchElementException(NoSuchElementException ex,WebRequest request){
		String errorMessageDescription =ex.getLocalizedMessage()+"fromhamz";
		if(errorMessageDescription == null ) errorMessageDescription=ex.toString();
		ResponseMessage errorMessage =new ResponseMessage(new Date(),errorMessageDescription);
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= {EmptyResultDataAccessException.class})
	public ResponseEntity<Object> handlNoSuchElementException(EmptyResultDataAccessException ex,WebRequest request){
		String errorMessageDescription =ex.getLocalizedMessage()+"fromhamz";
		if(errorMessageDescription == null ) errorMessageDescription=ex.toString();
		ResponseMessage errorMessage =new ResponseMessage(new Date(),errorMessageDescription);
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= {ResourceNotFoundException.class})
	public ResponseEntity<Object> handlResourceNotFoundException(ResourceNotFoundException ex,WebRequest request){
		String errorMessageDescription =ex.getLocalizedMessage();
		if(errorMessageDescription == null ) errorMessageDescription=ex.toString();
		ResponseMessage errorMessage =new ResponseMessage(new Date(),errorMessageDescription);
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}
	
	
	
}
