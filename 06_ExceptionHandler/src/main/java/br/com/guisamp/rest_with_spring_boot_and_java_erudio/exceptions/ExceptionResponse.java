package br.com.guisamp.rest_with_spring_boot_and_java_erudio.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Date timeStamp;
	private String message;
	private String details;
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public ExceptionResponse(Date timeStamp, String message, String details) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
}
