package com.string.example;

import java.io.*;
import java.util.*;

public class bubblesorthacker {
    private static int temp=0;
    private static int[] a;
    private static Scanner  sin=null;
public static void swap(int a,int b)
{
    temp=a;
    a=b;
    b=temp;
    
}
    public static void main(String[] args) {
        int count=0,n=0;
        sin=new Scanner(System.in);
        n=sin.nextInt();
        a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sin.nextInt();
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < n; i++) {
    
    for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
            count++;
            swap(a[j], a[j + 1]);
        }
    }
    
}
        System.out.println("Array is sorted in "+count+  " swaps.");
                System.out.println("First Element: "+a[0]);
        System.out.println("Last Element:"+a[n-1]);

        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}