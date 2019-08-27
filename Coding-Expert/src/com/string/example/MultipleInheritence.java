package com.string.example;

class Parent
{
	static void a() {
		System.out.println("Asdas1");
	}
}
class Child extends Parent
{
	 static void a() {
		System.out.println("Asdas");
	}
}
public class MultipleInheritence {

	public static void main(String[] args) {

		Parent a=new Parent();
		B b=new B();
		Parent a1=new Child();
		a1.a();
	}

}
