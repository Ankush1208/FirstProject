package com.streams.examples;

public class Student {
        
	private String name;
	private int age;

	protected void a()
	{
		System.out.println("s");
	}
	public Student(String name, int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString()
	{
		return "Name of Student is: " + name + "\nage of student is: "+ age;
	}
	

}
