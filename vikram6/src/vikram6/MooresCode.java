package vikram6;

import java.util.Scanner;

public class MooresCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string to encode: ");
		s=sc.nextLine();
		CharCode c = new CharCode();
		for(int i = 0; i<s.length();i++)
		{
			//System.out.println(s.charAt(i));
			System.out.print(c.getMooresCode(s.charAt(i)));
			System.out.print(" ");
		}

	}
	

}
