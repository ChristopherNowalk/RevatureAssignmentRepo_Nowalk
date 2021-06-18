
public class LinearSearch {
	public static void main(String[] args) {
		//dummy data for our method
		char letter = 'a';
		
		char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
				'r','s','t','u','v','w','x','y','z'};
		char[] lettersNull = null;
		
		LinearSearch ls = new LinearSearch();
		//calling methods
		System.out.println(ls.findLetter(letter, lettersNull));
	}
	
	//write first method here
	public int findLetter(char target, char[] data) {
		//if the data we take as an input is null or uninitialized the we return -1
		if(data == null) {
			return -1;
		}
		
		//we return -1 if the data is not found in the array
		int result = -1;
		for(int i = 0; i < data.length; i++) {
			//temporary holder for our data
			char temp = data[i];
			//testing current element against our target, if it matches we return the targets index
			if(temp == target) {
				return i;
			}
		}
		
		return result;
	}
}
