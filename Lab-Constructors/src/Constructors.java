
public class Constructors {
	
	public Constructors(int value) {
		System.out.println(value);
	}
	public Constructors() {
		System.out.println("Default no args constructor ran");
	}
	
	public static void main(String[] args) {
		Constructors c = new Constructors(55);
		
		//trying to use the no-arg constructor after we have made a new no-args constructor
		//we have to make a new no-args constructor when we define a custom constructor because
		//java removes the default constructor of a class when you make your own
		Constructors cNoArg = new Constructors();
	}
}
