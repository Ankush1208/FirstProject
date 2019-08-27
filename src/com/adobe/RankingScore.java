package com.adobe;

import java.util.Arrays;

public class RankingScore {

	 static int[] climbingLeaderboard(int[] scores, int[] alice) {

	      int l1=scores.length;
	      int l2=alice.length;
	       int j=0,k=l1+l2-1;
	         int i=scores.length-1;
	       int[] rank=new int[l1+l2];
	       while(i>=0 && j <l2) {
	    	   if(scores[i]<alice[j])
	    	   {
	    		   rank[k--]=scores[i--];
	    		   
	    	   }
	    	   else
	    		   rank[k--]=alice[j++];
	       }
	       while(i>=0) {
	    	   rank[k--]=scores[i--];
	    	   
	       }
	       while(j<l2)
	    	   rank[k--]=alice[j++];
	       System.out.println(Arrays.toString(rank));
	       return rank;
	       
	     	       }
	

	public static void main(String[] args) {

		int[] score= {100,90,90,80,75,60};
		//Arrays.sort(score);
		int[] alice= {50,65,77,90,102};
		climbingLeaderboard(score, alice);
	}

}
