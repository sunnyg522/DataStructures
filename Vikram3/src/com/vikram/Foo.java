package com.vikram;

public class Foo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String p[] = new String[10];
		p[0]="a";
		p[1]="b";
		p[2]="c";
		print(p);
	}

	public static void print(String array[])
	{
		try{
		for(int i =0 ;i < array.length;i++)
		{
			if(array[i]==null)
				throw new MyNullPointerException();
			System.out.print(array[i]);
		}
		}
		catch(MyNullPointerException e) {
			System.out.println("");
			System.out.println("Error! Reference is null");
			System.out.println("");
			
			e.printStackTrace();
			
		}
	}
}
