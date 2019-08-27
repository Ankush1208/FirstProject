package com.localdate.expressions;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {

	DateTimeFormatter d2=DateTimeFormatter.ofPattern("MM yy dd");

	LocalDate d1=LocalDate.of(2015, Month.APRIL, 14);
	
	public static void main(String[] args) {
		
	   LocalDateExample l1=new LocalDateExample();
	   System.out.println(l1.d1);
	   System.out.println(l1.d1.format(l1.d2));
		// TODO Auto-generated method stub

	}

}
