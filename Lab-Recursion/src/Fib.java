
public class Fib {
	
	public int fibonacci(int n) {
		
		//two base cases
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		//our recursive step
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
