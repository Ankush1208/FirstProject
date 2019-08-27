package com.amazon.interview;

public class MinimumWindowSubString {

	
  public static String find(String s, String p) {
      if(s==null||p==null)
    	  return "";
      String res="";
      int count=0,left=0,minlength=Integer.MAX_VALUE;
      int[] pattCount=new int[128];
      for(int i=0;i<p.length();i++)
    	  pattCount[p.charAt(i)]++;
      for(int j=0;j<s.length();++j)
      {
    	  if(--pattCount[s.charAt(j)] >=0)
    	  {
    		  count++;
    	  }
    	  while(count==p.length())
    	  {
    		  if(minlength>j-left+1)
    		  {
    			  minlength=j-left+1;
    			  res=s.substring(left,j+1);
    		  }
    		  
    		  if(++pattCount[s.charAt(left)] > 0)
    			  
    			 count--;
    		  left++;
    	  }
      }
      return res;
    }
	
	public static void main(String[] args) {
		
		String s1="this is a test string";
		String s2="tist";
		System.out.println(find(s1, s2));

		
	}

}
