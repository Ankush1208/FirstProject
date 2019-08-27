package com.streams.examples;

import java.util.*;

public class StreamExamples {

	public static void main(String[] args) {

		List<Integer> l1 = Arrays.asList(3, 4, 2, 3, 4, 4, 3, 3, 3, 2, 1, 1, 0);
		Integer i = l1.stream().max(Comparator.comparing(Integer::valueOf)).get();
		int i1 = Collections.max(l1);
		System.out.println(i + " " + i1);

		long distinct = l1.stream().distinct().count();
		System.out.println(distinct);

		Map<Integer, Integer> m1 = new TreeMap<Integer, Integer>();
		for (Integer i2 : l1) {
			if (m1.containsKey(i2)) {
				m1.put(i2, m1.get(i2) + 1);
			} else
				m1.put(i2, 1);
		}
		System.out.println(m1.remove(100));

	}

}
