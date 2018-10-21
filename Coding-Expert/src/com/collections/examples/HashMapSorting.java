package com.collections.examples;
import java.util.*;
import java.util.Map.Entry;
public class HashMapSorting {

	private static Map<Integer,String> m1=null;

	public static void main(String[] args) {
		
		m1=new HashMap<Integer,String>();
		m1.put(3, "a");
		m1.put(1, "b");
		m1.put(5, "c");
		m1.put(4, "d");
		m1.put(10, "e");
	   m1.put(null, "1");	
	   System.out.println(m1.remove(3));
		System.out.println(m1.get(null));
		TreeMap<Integer,String> t1=new TreeMap<Integer,String>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
		
			return (o1.compareTo(o2));
			}
			
		});
		t1.putAll(m1);
		
		
		System.out.println(t1);
		
		
	/*	Iterator i1=m1.entrySet().iterator();
		
		for(Map.Entry<Integer, String> entry:m1.entrySet())
			System.out.println(entry.getKey());*/
	}

}
