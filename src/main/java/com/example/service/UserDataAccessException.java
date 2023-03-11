package com.example.service;

public class UserDataAccessException extends Exception {

	private static final long serialVersionUID = -4798965926484615958L;
	
	public UserDataAccessException(String errorMessage) {
		super(errorMessage);
	}
}
