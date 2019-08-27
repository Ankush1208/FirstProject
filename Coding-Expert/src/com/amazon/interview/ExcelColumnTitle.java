package com.amazon.interview;

public class ExcelColumnTitle {
	private static void printString(int columnNumber) {

		// To store result (Excel column name)
		StringBuilder columnName = new StringBuilder();

		while (columnNumber > 0) {
			// Find remainder
			int rem = columnNumber % 26;

			// If remainder is 0, then a
			// 'Z' must be there in output
			if (rem == 0) {
				columnName.append("Z");
				columnNumber = (columnNumber / 26) - 1;
			} else // If remainder is non-zero
			{
				columnName.append((char) ((rem - 1) + 'A'));
				columnNumber = columnNumber / 26;
			}
		}

		// Reverse the string and print result
		System.out.println(columnName.reverse());
	}

	// Driver program to test above function
	public static void main(String[] args) {
		printString(27);
		printString(51);
		printString(52);
		printString(80);
		printString(676);
		printString(702);
		printString(705);
	}
}

// This code is contributed by Harikrishnan Rajan