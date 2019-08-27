package com.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Array2D {

	static long arrayManipulation(int n, int[][] queries) {


        int temp[] =new int[n];
        Arrays.fill(temp,0);
        for(int i=0;i<queries.length;i++)
        {
            findSum(queries[i][0],queries[i][1],queries[i][2],temp);
        }
         int max=Arrays.stream(temp).max().getAsInt();
        long m1=max;
        return m1;

    }
    static int[] findSum(int low,int high,int sum,int[] arr)
    {
        for(int i=low;i<=high;i++)
        {
                 arr[i]=sum+arr[i];
        }
        return arr;
    }
	public static void main(String[] args) {

		Scanner sin=new Scanner(System.in);
   // int m=sin.nextInt();
		int[][] arr=new int[2][3];
		System.out.println(arr.length);
	}

}
