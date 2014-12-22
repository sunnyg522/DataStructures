public class security extends app
{
	private int key;
	private int p;
	private int C;

	void encryp(int[] PhoneNumbers)

	{

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[0] = p;
			key = 1;
			C = (p + key) % 10;
			System.out.println("Digit 1 is:" + C);
			C = PhoneNumbers[0];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[1] = p;
			key = 1;
			C = (p + key) % 10;
			System.out.println("Digit 2 is:" + C);
			C = PhoneNumbers[1];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[2] = p;
			key = 1;
			C = (p + key) % 10;
			System.out.println("Digit 3 is:" + C);
			C = PhoneNumbers[2];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[3] = p;
			key = 3;
			C = (p + key) % 10;
			System.out.println("Digit 4 is:" + C);
			C = PhoneNumbers[3];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[4] = p;
			key = 3;
			C = (p + key) % 10;
			System.out.println("Digit 5 is:" + C);
			C = PhoneNumbers[4];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[5] = p;
			key = 3;
			C = (p + key) % 10;
			System.out.println("Digit 6 is:" + C);
			C = PhoneNumbers[5];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[6] = p;
			key = 5;
			C = (p + key) % 10;
			System.out.println("Digit 7 is:" + C);
			C = PhoneNumbers[6];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[7] = p;
			key = 5;
			C = (p + key) % 10;
			System.out.println("Digit 8 is:" + C);
			C = PhoneNumbers[7];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[8] = p;
			key = 5;
			C = (p + key) % 10;
			System.out.println("Digit 9 is:" + C);
			C = PhoneNumbers[8];
		}

		for (int i = 0; i < PhoneNumbers.length; i++) {
			PhoneNumbers[9] = p;
			key = 5;
			C = (p + key) % 10;
			System.out.println("Digit 10 is:" + C);
			C = PhoneNumbers[9];
		}
	}
	void undo(int[] ReverseNumbers)
	{
		int[] PhoneNumbers = { 4, 0, 8, 3, 7, 0, 8, 7, 1, 3 };

		System.out.println("After encryption, number is:");
		for (int i = 0; i < ReverseNumbers.length; i++) {
			System.out.print(ReverseNumbers[i] + " ");
		}


		if (p<0) {
			p = p + 10;

		}
		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[0] = p;
			key = 1;
			C = (p + key) % 10;
			System.out.println("original digit 1 is:" + C);
			C = PhoneNumbers[0];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[1] = p;
			key = 1;
			C = (p + key) % 10;
			System.out.println("original 2 is:" + C);
			C = PhoneNumbers[1];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[2] = p;
			key = 1;
			C = (p + key) % 10;
			System.out.println("Original 3 is:" + C);
			C = PhoneNumbers[2];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[3] = p;
			key = 3;
			C = (p + key) % 10;
			System.out.println("Original 4 is:" + C);
			C = PhoneNumbers[3];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[4] = p;
			key = 3;
			C = (p + key) % 10;
			System.out.println("Original 5 is:" + C);
			C = PhoneNumbers[4];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[5] = p;
			key = 3;
			C = (p + key) % 10;
			System.out.println("Original 6 is:" + C);
			C = PhoneNumbers[5];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[6] = p;
			key = 5;
			C = (p + key) % 10;
			System.out.println("Original 7 is:" + C);
			C = PhoneNumbers[6];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[7] = p;
			key = 5;
			C = (p + key) % 10;
			System.out.println("Original 8 is:" + C);
			C = PhoneNumbers[7];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[8] = p;
			key = 5;
			C = (p + key) % 10;
			System.out.println("Original 9 is:" + C);
			C = PhoneNumbers[8];
		}

		for (int i = 0; i < ReverseNumbers.length; i++) {
			ReverseNumbers[9] = p;
			key = 5;
			C = (p + key) % 10;
			System.out.println("Original 10 is:" + C);
			C = PhoneNumbers[9];
		}

	}
}