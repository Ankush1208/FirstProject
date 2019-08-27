package com.amazon.interview;

public class EquilibriumIndexInArray {
	int equi(int arr[], int n) {
		int sum = 0;
		int leftsum = 0;

		for (int i = 0; i < n; ++i)
			sum += arr[i];

		for (int i = 0; i < n; ++i) {
			sum -= arr[i];

			if (leftsum == sum)
				return i;

			leftsum += arr[i];
		}

		return -1;
	}

	public static void main(String[] args) {
		EquilibriumIndexInArray equi = new EquilibriumIndexInArray();
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		int arr_size = arr.length;
		int indexequi = equi.equi(arr, arr_size);
		System.out.println(indexequi);
	}
}