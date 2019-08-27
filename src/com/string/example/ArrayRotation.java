package com.string.example;


import java.util.Scanner;

public class ArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }  arrayRotation(a,n,k);
            printArrayRotated(a);
            
        
    }
    private static void printArrayRotated(int [] arr){
        for(int i:arr)
            System.out.print(i + " ");
        
    }
    private static void arrayRotation(int[] arr, int n, int d)
    {
        int temp=0;
        int x=d;
        if(n<=0||n>100000)
            return;
        if(d<0||d>n)
            return;
       
        for(int i=0;i<=d;i++)
        {
        	temp=arr[i];
        	arr[i]=arr[x];
        	arr[x]=temp;
        	x++;
        }
        System.out.println(x);
       
        
        
        
    }
}