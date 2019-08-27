package com.string.example;

import java.util.Arrays;
import java.util.*;

public class RansomStrings {

	public static void main(String[] args) {
		
		String s1="abc";
		int length=s1.length();
		generateAllStrings(s1);
		
	}

	private static void generateAllStrings(String s1) {
		
		if(s1.length()==1){
System.out.print (s1+" ");
		return;}
		else
		{System.out.print(s1+" ");
		 generateAllStrings(s1.substring(0,s1.length()-1));
		 generateAllStrings(s1.substring(1,s1.length()));

		// TODO Auto-generated method stub
		}
	}

}