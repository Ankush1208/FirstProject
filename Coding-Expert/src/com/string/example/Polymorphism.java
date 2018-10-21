package com.string.example;

class Bc {
	public void asdas() {
		System.out.println("hi");
	}
}

class CC extends Bc{
	
	int i;
	String i1;
	void a1() {
		super.asdas();
		System.out.println("yo");
	}
	public void asdas() {
	   this.a1();
		
		System.out.println("hello");
		
	}
}

public class Polymorphism {

	public static void main(String[] a) throws CloneNotSupportedException
	{

		String st3="aas";
		String st1=new String("aas");
		String st2="aas";

		System.out.println(st1.hashCode());
		System.out.println(st2.hashCode());
		System.out.println(st3.hashCode());

		System.out.println(st1==st2);
		CC c1=new CC();
		Bc c2= new CC();
		Bc c3=new Bc();
		c1.asdas();
		c2.asdas();
		c3.asdas();
		String s1="HI";
		s1=s1.toLowerCase();
		System.out.println(s1);
		Polymorphism p1=new Polymorphism();
		String p2 = p1.toString();
	System.out.println(p2.toString());
		
	}
	
}
