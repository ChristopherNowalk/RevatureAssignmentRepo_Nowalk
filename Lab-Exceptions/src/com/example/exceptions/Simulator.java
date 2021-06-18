package com.example.exceptions;

import java.util.Scanner;

public class Simulator {
	public static void main(String[] args) {

		getInput();
	}
	
	public static void getInput() {
		Scanner in = new Scanner(System.in);
		
		//get input from user
		System.out.println("Type in a number and press enter...");
		String line = in.nextLine();
		System.out.println("You've typed: " + line);
		
		//test if number is even, throw exception if true
		if(isEven(line)) {
			try {
				throw new EvenNumberException();
			}catch (EvenNumberException e) {
				e.printStackTrace();
			}finally {
				in.close();
			}

		}		
		//close resources
		in.close();
	}
	
	public static boolean isEven(String num) {
		//convert value to a number
		int value = Integer.parseInt(num);
		
		return (value % 2 == 0);
	}
}
