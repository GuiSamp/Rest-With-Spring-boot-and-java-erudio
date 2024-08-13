package br.com.guisamp.rest_with_spring_boot_and_java_erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.guisamp.rest_with_spring_boot_and_java_erudio.exceptions.ExceptionResponse;
import br.com.guisamp.rest_with_spring_boot_and_java_erudio.exceptions.UnsuportedMathOperationExceptione;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(UnsuportedMathOperationExceptione.class)
    public ResponseEntity<ExceptionResponse> unsuportedMathOperationExceptione(UnsuportedMathOperationExceptione exception, WebRequest request){
    	ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
    	
    	return new ResponseEntity<ExceptionResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR); 
    }
  
}
