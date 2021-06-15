import java.util.Scanner;

public class ExampleOne {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please type in a line and press Enter");
		String line = scanner.nextLine();
		
		System.out.println("You have typed: " + line);
		scanner.close();
		
		String numbers = "1 2 3 4 5 6 7 8";
		
		scanner = new Scanner(numbers);
		
		while(scanner.hasNextInt())
		{
			System.out.println(scanner.nextInt());
		}
		scanner.close();
	}
}
