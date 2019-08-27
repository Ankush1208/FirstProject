package com.dynamicProgramming.examples;

public class longestSubwithOutRepeating {

	public static void main(String[] args) {

		String str = "aabbccdde";
		findlongSubRep(str, str.length());
	}

	private static void findlongSubRep(String str, int l) {

		int max_len = 1;
		int curr_len = 1;
		int prev = 0;
		int[] visited = new int[256];

		for (int i = 0; i < visited.length; i++)
			visited[i] = -1;

		visited[str.charAt(0)] = 0;

		for (int i = 1; i < l; i++) {
			prev = visited[str.charAt(i)];
			if (prev == -1 || i - curr_len > prev)
				curr_len++;
			else {
				if (curr_len > max_len)
					max_len = curr_len;
				curr_len = i - prev;

			}
			visited[str.charAt(i)] = i;
		}
		if (curr_len > max_len)
			curr_len = max_len;

		System.out.println(max_len);
	}

}
