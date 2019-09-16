package com.notification.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidNumberException extends RuntimeException {
	
		private static final long serialVersionUID = 1L;

		 public InvalidNumberException() {
		        super();
		    }
		    public InvalidNumberException(String message, Throwable cause) {
		        super(message, cause);
		    }
		    public InvalidNumberException(String message) {
		        super(message);
		    }
		    public InvalidNumberException(Throwable cause) {
		        super(cause);
		    }

}
