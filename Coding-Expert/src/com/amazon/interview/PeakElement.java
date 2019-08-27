package com.amazon.interview;

public class PeakElement {

	public static void main(String[] args) {
		// int[] array={10,20,30,40};
		// int[] array={50,40,30,20,10};
		int[] array = { 5, 10, 20, 15 };
		int i = 0;
		int peak = 0;
		while (i < array.length - 1 && array[i] < array[i + 1])
			i++;
		if (i == array.length - 1) {
			System.out.println(array[array.length - 1]);
			return;
		}
		if (i == 0) {
			while (i < array.length - 1 && array[i] > array[i + 1])
				i++;
			if (i == array.length - 1) {
				System.out.println(array[0]);
				return;
			}

		} else
			for (int j = 0; j < array.length - 1; j++) {
				if (j == 0) {
					peak = array[j];
				} else if (j != array.length - 1) {
					if (array[j] > array[j - 1] && array[j] > array[j + 1]) {
						if (peak < array[j])
							peak = array[j];
					}
				} else

				if (j == array.length - 1)
					if (peak < array[j])
						peak = array[j];
			}
		System.out.println(peak);

	}

}
