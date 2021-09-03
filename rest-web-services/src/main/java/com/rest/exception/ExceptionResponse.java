package com.rest.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;
	public ExceptionResponse(Date timeStamp, String message, String details) {
		super();
		this.timestamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimeStamp() {
		return timestamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timestamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
