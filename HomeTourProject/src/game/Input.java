package game;

import java.util.Scanner;
import fixtures.Fixture;
import fixtures.Room;

public class Input {
	//find a way to close the scanner because there is a bit of a memory problem here
	public String[] getInput() {
		//create our scanner
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		input.toLowerCase();
		String[] inputArray = parse(input);
		return inputArray;
	}
	
	public static String[] parse(String aInput) {
		//the input will be split with the space, the first index of the string array will be the command (go or inspect)
		//the second index of the string array will be the direction (north, south, etc...)
		String[] strArray = aInput.split(" ");
		return strArray;
	}
	
	
}
