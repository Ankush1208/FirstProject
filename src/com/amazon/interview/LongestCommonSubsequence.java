package com.amazon.interview;

public class LongestCommonSubsequence {

	private static int longestSequence(char[] s1, char[] s2) {
		if (s1 == null || s2 == null)
			return -1;
		
		int n=s1.length;
		int m=s2.length;

		int[][] lcs=new int[n+1][m+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				if(i==0||j==0)
				{
					lcs[i][j]=0;
				}
				else if(s1[i-1]==s2[j-1])
					lcs[i][j]=1+lcs[i-1][j-1];
				else
					lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		
		return lcs[n][m];
	}

	public static void main(String[] args) {

		String text1 = "geeksforgeeks";
		String text2 = "ksforngf";
		char s1[] = text1.toCharArray();
		char s2[] = text2.toCharArray();

		int longest = longestSequence(s1, s2);
		System.out.println(longest);
	}

}
