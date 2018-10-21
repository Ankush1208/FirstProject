package com.string.example;

import java.util.ArrayList;

public class Stringexample {
	
	public static void arrayex(String n,String l2)
	{
		n="adasas";
		l2="asddasdad";
	}
	public static void main(String...a)
	{
		ArrayList<Integer> l1=new ArrayList<Integer>();
		int i=10;
		l1.add(1);
		l1.add(2);
		System.out.println(i);
		System.out.println(l1);
		String a1=new String("asd");
		String a2=new String("asd");
		String a3=a2.intern();
		String a4="asd";
		String a5=a4.intern();
		String s1="hello";
		s1="hello2";
		arrayex(s1, a3);

		System.out.println(a1.equals(a2));
		System.out.println(a1.equals(a4));
		System.out.println(a1.equals(a3));
		System.out.println(a1==a2);
		System.out.println(a3==a4);
System.out.println(s1 + a3);


		
	}

}
