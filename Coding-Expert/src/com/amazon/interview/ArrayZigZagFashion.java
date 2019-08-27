package com.amazon.interview;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArrayZigZagFashion {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
		arr = Arrays.stream(arr).boxed().collect(Collectors.groupingByConcurrent(c -> c, Collectors.counting()))
				.entrySet().stream().filter(p -> p.getValue() > 1).map(e -> e.getKey())
				.mapToInt(Integer::intValue)
				.toArray();
		System.out.println(Arrays.toString(arr) );
		String[] arr1= {"asd"};
		//Optional<String> o1= Arrays.stream(arr1).findAny();
		//boolean b=Arrays.stream(arr1).findAny().isPresent();
		if( Optional.ofNullable(arr1).isPresent()  )
		{
			Optional<String> o1=Arrays.stream(arr1).findAny();
			if(o1.isPresent())
			{
				//String s1=Arrays.stream(arr1).findAny().get();
			System.out.println(o1.get());
			}
		}
		
		int[] array = { 4, 3, 7, 8, 6, 2, 1 };
		zigZagArray(array);
	}

	private static void zigZagArray(int[] array) {
		boolean flag = true;

		int temp = 0;

		for (int i = 0; i <= array.length - 2; i++) {
			if (flag) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			} else {
				if (array[i] < array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
			flag = !flag;
		}
		System.out.println(Arrays.toString(array));
	}

}
