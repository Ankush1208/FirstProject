package com.adobe;

/*Brian Kernighan’s Algorithm:(count number of set bits)
 * Subtraction of 1 from a number toggles all the bits (from right to left) 
 * till the rightmost set bit(including the rightmost set bit). 
 * So if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), 
 * we unset the rightmost set bit. If we do n & (n-1) in a loop and count 
 * the no of times loop executes we get the set bit count.
The beauty of this solution is the number of times it loops is equal to 
the number of set bits in a given integer.
*/
public class CountBits {

	public static void main(String[] args) {

		int n = 1;
		countSetBits(n);
		int i=countUnsetBits(n);
		System.out.println(i);
	}
	static int countUnsetBits(int n) 
	{ 
		int x = n; 

		// Make all bits set MSB 
		// (including MSB) 
		
		// This makes sure two bits 
		// (From MSB and including MSB) 
		// are set 
		n |= n >> 1; 

		// This makes sure 4 bits 
		// (From MSB and including MSB) 
		// are set 
		n |= n >> 2; 

		n |= n >> 4; 
		n |= n >> 8; 
		n |= n >> 16; 

		// Count set bits in toggled number 
		return Integer.bitCount(x ^ n); 
	} 
	private static void countSetBits(int n) {

		int count = 0;
		while (n > 0) {
			n = n & (n - 1);
			count++;
		}
		System.out.println(count);
	}

}
