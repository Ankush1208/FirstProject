package com.adobe;

public class TestClass {
static int count=0;

    public void printSubSets(int N, int curr, String res){
        if(curr==0){
         //  System.out.println(res);
        	count++;

            return;
        }

        for (int i = 2; i <=N ; i+=2) {
            if(i<=curr){
                printSubSets(N, curr-i, res+i);
            }
        }
    }

    public static void main(String[] args) {
	    int N = 8;
	
        new TestClass().printSubSets(N,N,"");
        System.out.println(count);
    }
}