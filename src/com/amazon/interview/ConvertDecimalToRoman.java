package com.amazon.interview;

import java.util.HashMap;
import java.util.Scanner;

public class ConvertDecimalToRoman {

	private final static String roman[] = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
	private final static int number[] = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
	private static final HashMap<Integer, String> h1 = new HashMap<Integer, String>();
	private static Scanner sin;

	public static void main(String[] args) {

		int x = 0;
		for (int num : number) {

			h1.put(num, roman[x]);
			x++;

		}
		sin = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sin.nextInt();
		findRoman(n);
	}

	private static void findRoman(int n) {

		int quotient = 0;
		String rom = null;
		while (n != 0) {
			if (n >= 1000) {

				quotient = n / 1000;
				n = n % 1000;
				rom = h1.get(1000);
				concatString(rom, quotient, 1000);
			}
			if (n >= 900 && n < 1000) {
				quotient = n / 900;
				n = n % 900;
				rom = h1.get(900);
				concatString(rom, quotient, 900);
			}
			if (n >= 500 && n < 900) {
				quotient = n / 500;
				n = n % 500;
				rom = h1.get(500);
				concatString(rom, quotient, 500);
			}
			if (n >= 400 && n < 500) {
				quotient = n / 400;
				n = n % 400;
				rom = h1.get(400);
				concatString(rom, quotient, 400);
			}
			if (n >= 100 && n < 400) {
				quotient = n / 100;
				n = n % 100;
				rom = h1.get(100);
				concatString(rom, quotient, 100);
			}
			if (n >= 90 && n < 100) {
				quotient = n / 90;
				n = n % 90;
				rom = h1.get(90);
				concatString(rom, quotient, 90);
			}
			if (n >= 50 && n < 90) {
				quotient = n / 50;
				n = n % 50;
				rom = h1.get(50);
				concatString(rom, quotient, 50);
			}
			if (n >= 40 && n < 50) {
				quotient = n / 40;
				n = n % 40;
				rom = h1.get(40);
				concatString(rom, quotient, 40);
			}
			if (n >= 10 && n < 40) {
				quotient = n / 10;
				n = n % 10;
				rom = h1.get(10);
				concatString(rom, quotient, 10);
			}
			if (n >= 9 && n < 10) {
				quotient = n / 9;
				n = n % 9;
				rom = h1.get(9);
				concatString(rom, quotient, 9);
			}
			if (n >= 5 && n < 9) {
				quotient = n / 5;
				n = n % 5;
				rom = h1.get(5);
				concatString(rom, quotient, 5);
			}
			if (n >= 4 && n < 5) {
				quotient = n / 4;
				n = n % 4;
				rom = h1.get(4);
				concatString(rom, quotient, 4);
			}
			if (n >= 1 && n < 4) {
				quotient = n;
				n = n % 1;
				rom = h1.get(1);
				concatString(rom, quotient, 1);
			}

		}
	}

	private static void concatString(String rom, int rem, int n) {
		for (int i = 0; i < rem - 1; i++) {

			rom += h1.get(n);
		}
		System.out.print(rom);

	}

}
