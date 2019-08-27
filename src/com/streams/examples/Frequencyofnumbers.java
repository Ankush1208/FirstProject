package com.streams.examples;

import java.util.*;
import java.util.stream.Collectors;

public class Frequencyofnumbers {
	
	public static void main(String...a)
	{
		int max=0;
		int count=0;
		String s1[]= {"abcd","afgh","ajkl"};
		List<String> l1=Arrays.asList(s1).stream().
				filter(s->
					s.startsWith("a")
				)
				.peek(s->{s.replace("abcd", "a");
				  System.out.println(s);})
				.collect(Collectors.toList());
		System.out.println(l1);
	int[] arr= {1,2,2,2,2,11,3,3,3,3,6,6};
	Map<Integer,Integer> m1=new HashMap<Integer,Integer>();
	
	for(int i:arr)
	{
		if(m1.containsKey(i))
		{
			m1.put(i, m1.get(i)+1);
		}
		else
		m1.put(i, 1);
		
	}
	
	System.out.println(m1);
	for(Map.Entry<Integer, Integer> entry: m1.entrySet())
	{
		if(max< entry.getValue())
		{
			max=entry.getKey();
			count++;
		
		}
		
	}
	if(count==0)
		
	System.out.println(max);
	else
		System.out.println(-1);
	}

}
