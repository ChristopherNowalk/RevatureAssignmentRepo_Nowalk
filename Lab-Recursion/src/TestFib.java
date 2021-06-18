
public class TestFib {
	public static void main(String[] args) {
		Fib fib = new Fib();
		
		int result = fib.fibonacci(2);
		System.out.println(result);
		
		result = fib.fibonacci(5);
		System.out.println(result);
		
		result = fib.fibonacci(10);
		System.out.println(result);
	}
}
