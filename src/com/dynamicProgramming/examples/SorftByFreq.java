package com.dynamicProgramming.examples;

import java.util.*;
import java.util.Map.Entry;

public class SorftByFreq {
	private static HashMap<Integer, Integer> m1 = new HashMap<Integer, Integer>();
	// private static Map<Integer,Integer> m2=new TreeMap<Integer,Integer>();

	public static void main(String[] args) {

		int[] arr = { 2, 2, 2, 1, 1, 0, 0, 0, 3, 3, 3, 4 };
		for (int i : arr) {
			if (m1.containsKey(i))
				m1.put(i, m1.get(i) + 1);
			else
				m1.put(i, 1);
		}
		int l = arr.length;

		sortArray(arr, l);
		System.out.println(Arrays.toString(arr));

	}

	private static void sortArray(int[] arr, int l) {

		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(m1.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		int j = 0;
		for (Map.Entry<Integer, Integer> entry : list) {
			int i = entry.getValue();
			while (i-- > 0) {
				arr[j++] = entry.getKey();

			}
		}

	}
}
