package com.streams.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

 class Employee12{
	 private String name;
	 private Integer age;
	 
	 
	 public Employee12(){
		 super();
	 }
	 public Employee12(String name, Integer age){
		 this();
	  this.name=name;
	  this.age=age;
	 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee12 other = (Employee12) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	 
	}
	
	public  class Employee {
		
		protected void asdas() {
			 System.out.println("Asdas");
		 }
		
	 static List<Employee12> employeeList =
	     Arrays.asList(new Employee12("Tom Jones", 45), 
	       new Employee12("Harry Major,asdasd,123", 25),
	       new Employee12("Ethan Hardy", 65),
	       new Employee12("Nancy Smith", 15),
	       new Employee12("Deborah Sprightly", 29));
	 public static void main(String args[]) {
		 
		 Employee e1=new Employee();
	  List<Employee12> mappedList = employeeList.stream().
			             filter(s->{

			            	 if(s.getName().startsWith("H"))
			            	 
			            		 {String s1=s.getName();
			            		   s1=s1.replace("Harry Major", "");
			            		  // System.out.println(s1);
			            		   s.setName(s1);
			            	 return true;
			            		 }
			            	 return true;
			             }).
			  
	                   
	                     collect(Collectors.toList());
	  mappedList.forEach(s->System.out.println(s.getName()));
	  
	  HashSet<Employee12> h1=new HashSet<Employee12>();
	  h1.add(new Employee12("Ethan Hardy", 65));
	  h1.add(new Employee12("Ethan Hardy", 65));
	  System.out.println(h1.size());
	  

 
	 }
	}
