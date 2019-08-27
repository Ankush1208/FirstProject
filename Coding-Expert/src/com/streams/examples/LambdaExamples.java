package com.streams.examples;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaExamples {

	public static void main(String[] args) 
	{
		ArrayList<String> list=null;
		Predicate<String> p1= s->s.equals("amit");
		System.out.println(p1.test("amit"));
		
		
		/*********Sorting using class ***********************/
		
		/*
		 * list=new ArrayList<Student>();
		 * 
		 * list.add(new Student("rohit", 24));
		list.add(new Student("tarun", 26));
		list.add(new Student("ankush", 25));
		
		
		Comparator<Student> comp=(Student s1, Student s2) ->s1.getName().compareTo(s2.getName());
		Comparator<Student> comp1=(Student s1, Student s2) -> s1.getAge() -s2.getAge();
		Collections.sort(list,comp);
  
		for(Student s: list)
		{
			System.out.println(s.getAge() + " " + s.getName());
		}*/
		
		/*********** sorting using class end *******************/
		
		
		/****sorting of list *******/

		list=new ArrayList<String>();
		list.add("ankush");
		list.add("rohit");
		list.add("tarrun");
		list.add("sumit");
		list.add("tarrun");

       Collections.sort(list);
       System.out.println(list);
              
       /**** filter , findAny() and orElse(****/
       
       List<String> result=new ArrayList<String>();
       result=list.stream()
    		   .filter(s-> s.equals("ankush"))
    		   .collect(Collectors.toList());
       System.out.println("filter Result: " + result);
       
       System.out.println("find any : " +list.stream()
               .filter(s->s.startsWith("x"))
    		   .findAny()
    		   .orElse("not found"));
     
       /********************MAP() *********************/
       
       List<Student> list1=new ArrayList<Student>();
		 list1.add(new Student("rohit", 24));
		list1.add(new Student("tarun", 26));
		list1.add(new Student("ankush", 25));
		list1.add(new Student("ankush", 25));
  String f1="Asdas";
  String f2="nn";
  String f3=f1.concat(" "+f2);
  System.out.println(f3);
  
		System.out.println();
		String[] name=list1.stream()
				.filter(s->s.getName().equals("ankush")&& s.getAge()>20)
				.map(Student::getName)
				.collect(Collectors.toList()).toArray(new String[0]);
		String name1=list1.stream()
				.filter(s->s.getName().equals("ankush"))
				.map(Student::getName).collect(Collectors.toList()).toString();
		System.out.println("asa"+name1);
       System.out.println("Mapping name : " +Arrays.toString(name));
       
       /*** count frequency *****/
       
       int[] arr= {1,1,2,2,2,3,4,5,7,8,8,8,8,10,1};
      List<Integer> l1=Arrays.asList(1,1,2,2,2,3,4,5,7,8,8,8,8,10,1);
       Map<Integer, Long> res=l1.stream()
    		   .collect(
    	     Collectors.groupingBy(
    	    		 Function.identity(),Collectors.counting()
    	    		 )
    	     );
       System.out.println("Frequency of numbers are :" +res);
  
       /******Stream to array *******/
       
       Stream<Integer> st=l1.stream();
       
       List<Integer> stol=st.collect(Collectors.toList());
       l1.stream().map(i->i%2==0).sorted().forEach(s->System.out.print(s +" "));
       
       /** remove duplicates**/
       
    List<Integer> distinct=   l1.stream()
       .distinct()
      .collect(Collectors.toList());
       distinct.forEach(x->System.out.print(x));
       System.out.println();

       /****Dates****/
       
       LocalDate start=LocalDate.now();
       LocalDate end=LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
       
       /** last day of month***/
       
       System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
       
       /************************/
       
       List<LocalDate> dates=Stream.iterate(start, date -> date.plusDays(1))
    		                       .limit(ChronoUnit.DAYS.between(start, end))
    		                       .collect(Collectors.toList());
       LocalDate maxdate= dates.stream()
    		   .max(Comparator.comparing(LocalDate::toEpochDay))
    		   .get();
       System.out.println(maxdate);
       
       
       
       /*****Object Comparison *************/
       
       List<Student> list2=new ArrayList<Student>();
		 list2.add(new Student("rohit", 24));
		list2.add(new Student("tarun", 26));
		list2.add(new Student("ankush", 25));
		list2.add(new Student("ankush", 25));
		Student s1=list2.stream().max(Comparator.comparing(Student::getAge)).get();
		System.out.println( s1);

		Student s2=list2.stream().min(Comparator.comparing(Student::getAge)).get();
		
		System.out.println(s2);
		
		list2.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge));
		System.out.println(list2);
		
		/**** Parallel Sorting *******/
		
		Student[] student=list2.toArray(new Student[list2.size()]);
		Arrays.parallelSort(student, Comparator.comparing(Student::getAge));
		System.out.println(student);

			
		
      /************* String joiner ***********/
	
		StringJoiner sjoin=new StringJoiner(",","|","|");
		sjoin.add("hello").add("there");
		System.out.println(sjoin);
		
		/***************average and Sum ************/
		
	double average= Arrays.stream(new int[] {1,2,3})
		             .map(n->n*2)
		             .average().getAsDouble();
	System.out.println(average);
	
	               int sum=Arrays.stream(new int[] {1,2,3})
                           .map(n->n*2)
                           .sum();
                           
	             System.out.println(sum);
                   
	             
	             /**************filter foreach map ****************/
	             
	             Arrays.stream(new String[] {"a","b","c"})
	                    /*.map(n->{
	                    	System.out.println("map is : " +n);
	                    	return n.toUpperCase();
	                    })*/
	                    .filter(n->
	                    {
	                    	System.out.println("filter is : " + n);
	                    	return n.startsWith("A");
	                    })
	                    .forEach(s->System.out.print("data is "+s));
	          
	             List<Student> colExa=list2
	            		 .stream()
	            		 .filter(s->s.getName().startsWith("t"))
	            		 .collect(Collectors.toList());
	             System.out.println(colExa);
	             
	             
	             Double aveAge=list2.stream()
                                 .collect(Collectors.averagingInt(p->p.getAge()));
	             System.out.println("Average age is :" +aveAge);
	             
	             /*********statistic summary ****************/
	             
	             IntSummaryStatistics ageSummary =
	            		    list2
	            		        .stream()
	            		        .collect(Collectors.summarizingInt(p -> p.getAge()));

	            		System.out.println(ageSummary);
	            		
	            		ForkJoinPool commonPool = ForkJoinPool.commonPool();
	            		System.out.println(commonPool.getParallelism()); 
	            		
	          }

}
