
public class ExampleOne {
	public static void main(String[] args) {
		//create some dummy data for our methods
		int i = 5;
		ExampleOne eo = new ExampleOne();
		//call methods here
		System.out.println(eo.factorial(i));
	}
	
	//create first method here
	public int factorial(int n) {
		//base cases
		if(n <= 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		//recursive call
		return n * factorial(n - 1);
	}
}
