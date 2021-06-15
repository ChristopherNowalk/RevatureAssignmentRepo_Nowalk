
public class MultiDimensionalArrays {
	public static void main(String[] args)
	{
		int[][][] my3DArray = new int[3][3][3];
		
		my3DArray[0][0][0] = 1;
		System.out.println(my3DArray[0][0][0]);
		
		int[][] my2dArray = {{1,2,0},{4,5,6},{1,4,5}};
		System.out.println(my2dArray.length);
		
		//the index for the number 6 is 1,2 because it is in the second array in the third index
		System.out.println(my2dArray[1][2]);
	}
}
