package com.array.questions;

public class FingerIdentification {

	public static void main(String[] args) {

		int n=17;
		int i=findFinger(n);
		System.out.println(i);
	}

	private static  int findFinger(int n) {
		
		int mod=n%8;
		
		if(mod==1 || mod==5)
			return mod;
		if(mod==0||mod==2)
			return 2;
		if(mod==3||mod==7)
			return 3;
		if(mod==6||mod==4)
			return 4;
		return 0;
	}

}
