package com.string.example;

//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

public class Solution1 {
static int result=0;
static TreeSet<Integer> s1=new TreeSet<Integer>();
static int length=0,max=0;
 public static int solution(int[] A) {
     // write your code in Java SE 8
   
      for(int i=0;i<A.length;i++)
      {
          if(A[i]<0)
           length++;
}
if(length==A.length){
result=1;
return result;
}
else
max=Arrays.stream(A).max().getAsInt();

for(int i=0;i<A.length;i++)
s1.add(A[i]);
for(int i=1;i<=max;i++){
if(s1.add(i)){
result=i;
break;}
else
result= i+1;
}
return result;
 }
 public static void main(String...a)
 
 {
	 int[] a1={1,2,3,4,6};
	 System.out.println(solution(a1));
 }
}
