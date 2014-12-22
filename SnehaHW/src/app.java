public class app {


	private static int[] reverseNumbers = { 5, 1, 9, 6, 0, 3, 3, 2, 6, 8 };
	static int[] PhoneNumbers ={ 4, 0, 8, 3, 7, 0, 8, 7, 1, 3 };;
	
	public void coding()
	{
		
		//reverseNumbers = new int[] 
		System.out.println("Before encryption, your number is:");
		for (int i = 0; i < PhoneNumbers.length; i++) {
			System.out.print(PhoneNumbers[i] + " ");
		}
	}


	public static void main(String[] args) {
		// TODO code application logic here 
		security codes = new security();
		
		codes.encryp(PhoneNumbers);
		codes.undo(reverseNumbers); 
		
	}
}