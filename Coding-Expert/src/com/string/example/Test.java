package com.string.example;

import java.util.*;

public class Test {
int id;
String name;
public Test(int id,String name)
{
	this.id=id;
	this.name=name;
}
    private static Scanner input;

	public static void main(String[] args) {
		
		Test t1=new Test(1,"asdas");
		Test t2=new Test(1,"asdas");
		System.out.println(t1.equals(t2));

		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
        input = new Scanner(System.in);
        int pairs = input.nextInt(); input.nextLine();
        
        for(int t = 0; t < pairs; t++)
        {
            String a = input.nextLine();
            String b = input.nextLine();
            
            Set<Character> aLetterSet = new HashSet<>();
            Set<Character> bLetterSet = new HashSet<>();
            
            //Populate the sets
            for(int i = 0; i < a.length(); i++)
                aLetterSet.add(a.charAt(i));
            
            for(int i = 0; i < b.length(); i++)
                bLetterSet.add(b.charAt(i));
            
            //Perform the intersection of the two sets
            aLetterSet.retainAll(bLetterSet);
                
            if(aLetterSet.size() > 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}