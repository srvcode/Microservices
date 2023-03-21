package com.srvcode.rest.cache.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @ControllerAdvice is meant for classes that specify methods 
 * that are used across multiple controllers such as exception handlers.
 */

@ControllerAdvice
public class ProductNotFoundResponse {

	/*
	 * @ResponseBody specifies that the response from below method
	 * is a web response that should be rendered to the user.
	 * 
	 * @ExceptionHandler annotation declares this method as one which handles
	 * exceptions, specifically the ProductNotFoundException.
	 * 
	 * @ResponseStatus indicates that when this exception handler is hit,
	 * return the response with the mentioned httpStatus like NotFound.
	 */
	@ResponseBody
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String productNotFoundHandler(ProductNotFoundException exception) {
		return exception.getMessage();
	}
}
