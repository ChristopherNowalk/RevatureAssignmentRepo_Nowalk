package com.example.exceptions;

public class EvenNumberException extends Exception {
	@Override
	public String getMessage() {
		return "You cannot input an even number";
	}
}
