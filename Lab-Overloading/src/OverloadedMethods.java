
public class OverloadedMethods {
	public static void main(String[] args)
	{
		//create instance here
		OverloadedMethods om = new OverloadedMethods();
		
		om.print();
		
		om.print("Second print method");
		
		om.print("second", "third");
	}
	//overload methods here
	public void print()
	{
		System.out.println("Original print method");
	}
	
	public void print(String str)
	{
		System.out.println(str);
	}
	
	public void print(String str1, String str2)
	{
		System.out.println(str1 + " " + str2);
	}
	/*
	public void print(String first, String second)
	{
		System.out.println(first + " " + second);
	}
	*/
}
