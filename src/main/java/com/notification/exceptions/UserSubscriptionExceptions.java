package com.notification.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserSubscriptionExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	 public UserSubscriptionExceptions() {
	        super();
	    }
	    public UserSubscriptionExceptions(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public UserSubscriptionExceptions(String message) {
	        super(message);
	    }
	    public UserSubscriptionExceptions(Throwable cause) {
	        super(cause);
	    }

}
