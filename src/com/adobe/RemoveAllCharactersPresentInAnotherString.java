package com.adobe;

public class RemoveAllCharactersPresentInAnotherString {

	public static void main(String[] args) {

		String s1="geeksforgeeks";
		String s2="sfor";
		removeCharacters(s1,s2);
	}

	private static void removeCharacters(String s1, String s2) {
		
        int[] count=new int[256];
        char[] temp=new char[s1.length()];
        int x=0;
		for(int i=0;i<s2.length();i++)
		{
			count[s2.charAt(i)]++;
		}
		for(int i=0;i<s1.length();i++)
		{
			if(count[s1.charAt(i)]==0)
			{
				temp[x++]=s1.charAt(i);
			}
			
		}
		System.out.println(new String(temp).substring(0,x));
	}

}
