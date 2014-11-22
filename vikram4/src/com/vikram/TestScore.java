package com.vikram;

import java.lang.Math;
import java.text.DecimalFormat;

public class TestScore {
	double average =0;
	int i;
	public TestScore(double number[])
	{
		try{
		for( i=0;i<number.length;i++)
		{
			if(number[i]<0 || number[i]>100)
				throw new Exception("Error: Invalid score: "+number[i]);
			else 
				average = average+number[i];
		}
		}
		catch(Exception e)
		{
			System.out.println("Error: Invalid score: "+number[i]);
			System.out.println();
			System.out.println("Stack Trace:");
			e.printStackTrace();
		}
		finally
		{
			
			// this is to test comments for devbranch 
			
			// testing this comments to test git.
			DecimalFormat f = new DecimalFormat("##.00");
			System.out.println("Average Score: "+f.format(calcAverage(number)));
		}
	}
	public double calcAverage(double number[])
	{
		int aveNumber = 0 ;
		for(int i=0;i<number.length;i++)
		{
			if(number[i]<=0 || number[i]>100)
				average = average;
			else
			{
				aveNumber = aveNumber+1;
				average = average+number[i];
			}
		}
		return average/aveNumber;
	}

}
