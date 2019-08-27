package com.string.example;

public class EqualsandHashcode {
	
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EqualsandHashcode(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	@Override
	public boolean equals(Object ob)
	{
		if(ob==null)
		return false;

		if(!(ob instanceof EqualsandHashcode))
			return false;
		
		if(ob==this)
			return true;
		return this.getId()==((EqualsandHashcode)ob).getId();
	}
	
	@Override
	public int hashCode()
	{
		return id;
		
	}

	public static void main(String[] args) {

		
		EqualsandHashcode e1=new EqualsandHashcode(1, "anush");
		EqualsandHashcode e2=new EqualsandHashcode(1, "anush");
		
		System.out.println("e1 hashcode---> " +e1.hashCode());
		System.out.println("e2 hashcode---->" +e2.hashCode());
		System.out.println(e1.equals(e2));

	}

}
