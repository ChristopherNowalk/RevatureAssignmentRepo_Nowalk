
public class Test {

	public static void main(String[] args) {
		//we can also manually manipulate the static variable and it will still add 1 to the count
		//each time we make an instance
		A.staticCount = 2490;
		System.out.println("classA static count: " + A.staticCount);
		
		A a = new A();
		
		System.out.println(a.instanceCount);
		//since the staticCount variable is static, we have to reference it directly in the class
		//with the class name instead of the instance name(reference variable)
		System.out.println(A.staticCount);
		
		A a2 = new A();
		
		System.out.println(a2.instanceCount);
		//when we run this code now after initializing another instance of A, our static count 
		//will be 2 while our instance count will be 1
		System.out.println(A.staticCount);
		
		a.instanceCount = 15;
		//here we can manipulate the instance count of each instance of the class separately
		System.out.println("object a instance count: " + a.instanceCount);
		System.out.println("object a2 instance count: " + a2.instanceCount);
	}
}
