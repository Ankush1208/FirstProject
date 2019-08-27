package com.amazon.interview;

public class LookAndSaySeq {

	public static void main(String[] args) {
		int n = 5;

		String c1 = countAndSay(n);

		System.out.println(c1);
	}

	private static String countAndSay(int n) {

		if (n == 1)
			return "1";
		if (n == 2)
			return "11";

		String str = "11";

		for (int i = 3; i <= n; i++) {

			str += '$';
			int len = str.length();
			int cnt = 1;
			String tmp = "";

			for (int j = 1; j < len; j++) {
				if (str.charAt(j) != str.charAt(j - 1)) {
					tmp = tmp + cnt;
					tmp += str.charAt(j - 1);
					cnt = 1;
				}

				else
					cnt++;
			}

			str = tmp;
		}

		return str;

	}
}
