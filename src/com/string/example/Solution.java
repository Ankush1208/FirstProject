package com.string.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;


public class Solution {

  
    public static void main(String[] args) {
    	String[] dates={"31/08/2015","21/04/1999","01/02/2026","25/02/1991","02/01/2026"};
    	
    sortDates(dates);
    
for(String i:dates)
{
	System.out.print(i + " ");
}
    }
    

	private static String[] sortDates(String[] dates) {
		LocalDate ld=null;
	  
    	ArrayList<LocalDate> al=new ArrayList<LocalDate>();
    	
    	DateTimeFormatter d1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	for(String s1:dates)
    	{
    		ld=LocalDate.parse(s1,d1);
    		al.add(ld);
    		
    	}
   // LocalDate[] dates1= Stream.of(dates);
    	System.out.println(al);
Collections.sort(al,new Comparator<LocalDate>() {

	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		
		return o1.compareTo(o2);
	}
	
});

for(int i=0;i<dates.length;i++)
{
	dates[i]=al.get(i).format(d1);
}
		return dates;
		
	}
}
