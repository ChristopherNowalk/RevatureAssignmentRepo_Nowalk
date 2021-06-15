
public class StringMethods {
	public static void main(String[] args)
	{
		String str = "Hello";
		//the .equals() method compares the literal values of one string to another
		//it is however not the same as using ==
		System.out.println(str.equals("Hello"));
		
		//using the .length() method, it returns the # of characters in a string as an int
		System.out.println(str.length());
		
		//using the .indexOf() method, returning the index where a particular character is in
		//the string. If we choose a character that is in the string multiple times, it returns
		//only the first instance of that character
		System.out.println(str.indexOf('H'));
	}
}
