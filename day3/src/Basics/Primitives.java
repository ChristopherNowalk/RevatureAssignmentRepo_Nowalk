package Basics;

public class Primitives {
	public static void main(String[] args) {
		//basic hello world program
		System.out.println("Hello World");
		//simple boolean
		boolean on = true;
		System.out.println(on);
		
		//when we declare a float in java, the compiler automatically expects a decimal number
		//to be a double, so we have to specify the number as a float 
		float f = 333.4567F;
		//without the F (or f) at the end of the literal declaration of the float java will think
		//we want a double 
		
		//the same goes for a long, java automatically expects and int, so when we want to have
		//a long specifically we need to put an L at the end of our literal.
		//If the number is too long to be an int we will get an error message to remind us to 
		//specify it as a long
		long l = 12345678900L;
		
		
		//SIMPLE MATHS
		int x = 5;
		int y = 3;
		int z;
		
		//simple addition
		z = x + y;
		System.out.println(z);
		//simple subtraction
		z = x - y;
		System.out.println(z);
		//simple multiplication
		z = x * y;
		System.out.println(z);
		//simple division
		z = x / y;
		System.out.println(z);
		//simple modulus (modulus returns the remainder of the division)
		z = x % y;
		System.out.println(z);
		//float vs int
		int i = 22;
		int result;
		//when we want to add a float to an int, and store the result in an int, we must specify
		//that we are okay with losing that precision by casting the float to an int.
		result = (int)f + i;
		System.out.println(result);
		
		//switch statements
		x = 5;
		switch(x) {
			case 10: {
				System.out.println("case 10 ran");
				break;
			}
			default: {
				System.out.println("the default case ran");
			}
			//if we dont have a break statement then if one of the cases are true, then the
			//code block will continue to run down until it hits a break statement
			//that is called fall-through logic, although since our last case (the default case)
			//has no more cases below it, there is nothing to fall through to, so we dont need
			//a break there
			//the curly braces are also not needed inside the switch code block, but they are nice
			//to have to organize our thoughts more on the code that will be running in each case
		}
	}
}
