package com.string.example;

import java.util.*;

public class Test {
int id;
String name;
public Test(int id,String name)
{
	this.id=id;
	this.name=name;
}
    private static Scanner input;

	public static void main(String[] args) {
		Integer i1=128;
		Integer i2=128;
		System.out.println(i1==i2);
		Set<Test> s1=new HashSet<Test>();
		Test t1=new Test(1,"asdas");
		Test t2=new Test(2,"asdas");
		System.out.println(t1.equals(t2));
		s1.add(t1);
		s1.add(t2);
		System.out.println(s1.size());

		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
        
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (id != other.id)
			return false;
		/*
		 * if (name == null) { if (other.name != null) return false; } else if
		 * (!name.equals(other.name)) return false;
		 */
		return true;
	}
}