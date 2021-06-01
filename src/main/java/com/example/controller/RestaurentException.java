package com.example.controller;

public class RestaurentException extends Exception {
	
	
	private static final long serialVersionUID = 5814896057154845562L;
	
	private String msg;
	
	public RestaurentException(String msg) {
		this.msg= msg;
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}
