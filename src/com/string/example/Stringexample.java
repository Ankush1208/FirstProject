package com.string.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Stringexample {
	
	static int findUnorderedAnagramPairNum(String str) {
		Map<String, Integer> key2count = new HashMap<String, Integer>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String key = generateKey(str.substring(i, j));
				if (!key2count.containsKey(key)) {
					key2count.put(key, 0);
				}
				key2count.put(key, key2count.get(key) + 1);
			}
		}
		return key2count.values().stream().mapToInt(count -> count * (count - 1) / 2).sum();
	}

	static String generateKey(String str) {
		return str.chars().sorted().mapToObj(letter -> String.valueOf((char) letter)).collect(Collectors.joining());
	}
	
	public static void arrayex(String n,String l2)
	{
		n="adasas";
		l2="asddasdad";
	}
	public static void main(String...a)
	{
		findUnorderedAnagramPairNum("abab");
		ArrayList<Integer> l1=new ArrayList<Integer>();
		int i=10;
		l1.add(1);
		l1.add(2);
		System.out.println(i);
		System.out.println(l1);
		String a1=new String("asd");
		String a2=new String("asd");
		String a3=a2.intern();
		String a4="asd";
		String a5=a4.intern();
		String s1="hello";
		s1="hello2";
		arrayex(s1, a3);

		System.out.println(a1.equals(a2));
		System.out.println(a1.equals(a4));
		System.out.println(a1.equals(a3));
		System.out.println(a1==a2);
		System.out.println(a3==a4);
System.out.println(s1 + a3);


		
	}

}
