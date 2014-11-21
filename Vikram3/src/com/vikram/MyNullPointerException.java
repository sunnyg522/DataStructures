package com.vikram;

import javax.lang.model.type.NullType;

public class MyNullPointerException extends NullPointerException{
	public MyNullPointerException()
	{
		//System.out.println("Error ! Refference is null");
		super("Error ! Refference is null");
	}
	public MyNullPointerException(String message)
	{
		super(message);
	}

}
