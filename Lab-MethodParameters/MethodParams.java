
public class MethodParams {
	public static void main(String[] args)
	{
		//class instance
		MethodParams mp = new MethodParams();
		
		//call method
		double d = mp.convertIntToDouble(44);
		
		System.out.println(d);
		
		//call the second method
		System.out.println(mp.sum(1.0, 2, 3));
	}
	//create method
	public double convertIntToDouble(int num)
	{
		return (double)num;
	}
	
	//new sum method
	public double sum(double num1, int num2, int num3)
	{
		return num1 + num2 + num3;
	}
}
