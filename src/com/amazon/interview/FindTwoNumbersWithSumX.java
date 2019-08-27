package com.amazon.interview;

public class FindTwoNumbersWithSumX {

	public static void main(String[] args) {

		int n=74;

		boolean[] prime=new boolean[n+1];
		
		
		findPrime(n,prime);
	}

	private static void findPrime(int n, boolean[] prime) {

		prime[0]=false;
		prime[1]=false;
		for(int p=2;p<=n;p++)
		{
			prime[p]=true;
		}
		for(int p=2;p*p<=n;p++)
		{
			if(prime[p]==true)
			{
				for(int i=p*p;i<=n;i+=p)
				{
					prime[i]=false;
				}
			}
		}
		
		for(int i=2;i<n;i++)
		{
			if(prime[i] && prime[n-i]) {
				System.out.println(i + "  " +(n-i));
			return;
		}}
	}

}
