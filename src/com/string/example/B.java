package com.string.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

interface TestA{
	float getRange(int l, int h);

}
interface TestB{
	float getAvg(int a, int b, int c);
}
abstract class TestAbstract implements TestA,TestB{
	
}
class TestAImpl implements TestA{

	@Override
	public float getRange(int l, int h) {
		// TODO Auto-generated method stub
		return 3.14f;
	}
	
}

interface TestC extends TestB{
	float getAvg(int a, int b, int c);
}
public class B{
	
	public void a(int a,int b, int c) {
		System.out.println("as");
	}
	
	public void a(byte...b) {
		System.out.println("byte");
	}
	public static void main(String[] a1)
	{
		B b1=new B();
		byte b=10;
		b1.a(b,b,b);
		
		int[] arr= {2,3,10,2,4,8,1};
		Set<Integer> s2=new HashSet<Integer>();
		Integer i1=10;
		Integer i2=10;
		Integer i3=14;
		s2.add(i1);
		s2.add(i2);
		s2.add(i3);
		System.out.println(s2.size());
		Set<Integer> s3=new HashSet<Integer>();
		s3.add(1);
		s3.add(3);
		s3.add(4);
		HashMap<Integer, Set<Integer>> m1= new HashMap<Integer, Set<Integer>>();
		m1.put(1,s2);
		m1.put(2,s3);
				Set<Integer> s1=m1.get(2);
				if(s1.contains(9))
				{
					System.out.println("yes");
				}
				else
				System.out.println("no");
		
	}
	public static void main(Object[] args) {
		System.out.println("object");
	}
}
