package com.overloadingAndoverriding.example;

class over {

	
	
	
	protected  int  a(int b,int c)
	{
		System.out.println(b);
		return b;
		
	}
}
	class overriding extends over{
		 public int  a(int b,int c)
		{
			System.out.println(b+"d");
			return 12;
			
		}
	}
	public class Overloading{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		over o1=new overriding ();
		o1.a(1, 2);
		
	}

}
