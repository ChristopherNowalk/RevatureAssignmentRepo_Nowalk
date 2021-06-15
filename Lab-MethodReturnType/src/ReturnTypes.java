
public class ReturnTypes {
	public static void main(String[] args)
	{
		//class instance
		ReturnTypes rt = new ReturnTypes();
		
		//call first method
		rt.returnNothing();
		
		boolean b = rt.returnBoolean();
		
		System.out.println("The value of b is " + b);
	}
	//create first method
	public void returnNothing()
	{
		System.out.println("Inside of a void method");
	}
	
	public boolean returnBoolean()
	{
		return true;
	}
}
