package com.string.example;

public class Singleton  implements Cloneable{
	
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		super.clone();
		
		return getInstance();
	}
	static Singleton s1=null;
	String s=null;
	private Singleton() {
		this.s="sdsa";
	}
	public static Singleton getInstance()
	{
		if(s1==null)
			return  new Singleton();
		return s1;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
      Singleton s1= new Singleton();
      Singleton s2 = (Singleton) s1.clone();
      System.out.println(s1.hashCode());
      System.out.println(s2.hashCode());
		
	}

}
