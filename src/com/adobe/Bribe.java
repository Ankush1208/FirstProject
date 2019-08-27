package com.adobe;

public class Bribe {

	static void minimumBribes(int[] q, int low, int high) {
		int bribe = 0, flag = 0;
		while (high > low) {
			if (q[high] != high + 1) {
				if (q[high - 1] == high + 1) {
					bribe++;
					swap(q, high - 1, high);
				} else if (q[high - 2] == high + 1) {
					bribe += 2;
					swap(q, high - 2, high - 1);
					swap(q, high - 1, high);
				} else {
					System.out.println("Too chaotic");
					flag = 1;
					break;
				}
			}
			high--;
		}
		if (flag == 0)
			System.out.println(bribe);
	}

	static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 3, 7, 8, 6, 4 };
		int low = 0;
		int high = arr.length - 1;
		minimumBribes(arr, low, high);
	}
}
