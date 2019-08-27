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
			return 1;
			
		}
	}
	public class Overloading{
	/*
	 * public void b1(int a) { System.out.println("int"); }
	 */
		public void b1(Integer a) {
			System.out.println("Integer");
		}
		public void b1(int...a) {
			System.out.println("int");
		}
		public void b1(int a,int...b) {
			System.out.println("Integer");
		}
	
	  public void b1(long a) { System.out.println("long"); }
	 
		public void b1(Object a) {
			System.out.println("object");
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		over o2=new overriding ();
		Overloading o1=new Overloading();
		o2.a(1, 2);
		
	}

}
