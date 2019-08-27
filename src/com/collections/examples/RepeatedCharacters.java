package com.collections.examples;

import java.util.HashMap;
import java.util.Map;

public class RepeatedCharacters {
	
	String s1="adadasd";
	char[] c=s1.toCharArray();
	private static Map<Character,Integer> m1=new HashMap<Character,Integer>();
	
	public void findRepeatedCharacters()
	{
		for(Character c1:c)
		{
			if(m1.containsKey(c1))
			{
			
				m1.put(c1,m1.get(c1)+1 );
			}
			else
				m1.put(c1, 1);
		}
		for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
		    System.out.println("Character = " + entry.getKey() + ", count = " + entry.getValue());
		} 	 	
	}
	
	public static void main(String...a)
	{

	RepeatedCharacters r1=new RepeatedCharacters();
	r1.findRepeatedCharacters();
	

	
	}
	
}
