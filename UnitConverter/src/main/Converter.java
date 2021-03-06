package main;
//importing the scanner class
import java.util.Scanner;

public class Converter {
	public static void main(String[] args) {
		//making our scanner object
		Scanner scan = new Scanner(System.in);
		//array of string options to print out, the index will be 
		System.out.println("Please choose a conversion you wish to make");
		String[] selections = {"1. Gallons to Liters", "2. USD to CAD", "3. Feet to Miles", "4. Quit" };
		//enhanced for loop to print out the options for our converter program
		for(String option : selections) {
			System.out.println(option);
		}
		int input = scan.nextInt();
		int menuSelection = input;
		//loop to sit in while we make a selection
		while(menuSelection != selections.length) {
			//i can either use nested if statements or a switch statement
			switch(input) {
			case 1:
				System.out.println("How many gallons to convert to liters:");
				double gallons = scan.nextDouble();
				double liters = gallonsToLiters(gallons);
				System.out.println(gallons + " gallons is " + liters + " liters.");
				break;
			case 2:
				System.out.println("How many USD to convert to CAD:");
				double usd = scan.nextDouble();
				double cad = usdToCad(usd);
				System.out.println(usd + " USD is " + cad + " CAD");
				break;
			case 3:
				System.out.println("How many feet to convert to miles:");
				double feet = scan.nextDouble();
				double miles = feetToMiles(feet);
				System.out.println(feet + " Feet is " + miles + " Miles");
				break;
			case 4:
				break;
			}
			break;
		}
		scan.close();
	}
	
	//our conversion methods
	public static double gallonsToLiters(double aGallons) {
		double liters = aGallons * 3.78541;
		return liters;
	}
	
	public static double usdToCad(double aUsd) {
		double cad = aUsd * 1.22;
		//rounding off any remaining digits to make it a proper currency conversion with only
		//two decimal points
		cad = Math.round(cad * 100.0) / 100.0;
		return cad;
	}
	
	public static double feetToMiles(double aFeet) {
		double miles = aFeet * 0.000189394;
		return miles;
	}
}
