package com.amazon.interview;

public class MergeSort {

	private int[] array;
	private int[] tempMergArr;
	private int length;

	public static void main(String a[]) {

		int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
		//int[] inputArr = { 1, 20, 6, 4, 5 };
		MergeSort mms = new MergeSort();
		mms.sort(inputArr);
		for (int i : inputArr) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle+1, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle ;
		int k = lowerIndex;
		while (i <= middle -1 && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k++] = tempMergArr[i++];
			} else {
				array[k++] = tempMergArr[j++];
			}

		}
		while (i <= middle-1) {
			array[k++] = tempMergArr[i++];

		}
		while(j<=higherIndex)
		{
			array[k++]=tempMergArr[j++];
		}

	}
}