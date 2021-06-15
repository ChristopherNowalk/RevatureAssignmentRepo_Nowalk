
public class ClassB {
	//we are creating an instance of classA in classB so that classB can refer to classA
	ClassA classA = new ClassA();
	
	public static void main(String[] args) {
		ClassB b = new ClassB();
		b.classA.setName("Taylor");
		
		System.out.println(b.classA.getName());
	}
}
