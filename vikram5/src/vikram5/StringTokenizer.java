package vikram5;

import java.util.Scanner;

public class StringTokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s;
		//s = "This line is to tokenize bay buy bus thi bus ";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a line for me to tokenize:");
		s = sc.nextLine();
		System.out.println();
		tokenize(s, 'b');
	}
	public static void tokenize(String s, char token)
	{
		System.out.println("Tokens beginning with b:");
		System.out.println();
		String[] p = s.split(" ");
		for(int i = 0; i<p.length;i++)
		{
			if(p[i].charAt(0)=='b')
			{
				System.out.println(p[i]);
			}
			
		}
		
	}

}
