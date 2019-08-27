package com.collections.examples;

import java.util.*;
import java.util.Map.Entry;

public class HashMapSorting {
	static Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
  List<Integer> l1=new ArrayList<Integer>();
	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {

	      List<Integer> l1= new ArrayList<Integer>();

	        int size=queries.size();
	        for(int i=0;i<size;i++)
	        {
	        	

	             
	                   if(queries.get(i).get(0)==1)

	                      {
	                          int key=queries.get(i).get(1);
	                          if(m1.containsKey(key))
	                          {
	                              m1.put(key, m1.get(key)+1);
	                          }
	                          else
	                          m1.put(key,1);
	                      }
	                      if(queries.get(i).get(0)==2)
	                      {
	                                               int key=queries.get(i).get(1);

	                          if(m1.containsKey(key))
	                          {
	                              if(m1.get(key)==1)
	                              m1.remove(key);
	                              else if(m1.get(key)>1)
	                                 m1.put(key,m1.get(key)-1);
	                          }

	                      }
	                      if(queries.get(i).get(0)==3)
	                      {
	                          int value=queries.get(i).get(1);
	                          if(m1.size()==0)
	                          {
	                              l1.add(0);
break;
}
	                         
	                              if(m1.containsValue(value))
	                                             
	                              l1.add(1);
	                         
	                          else
	                          l1.add(0);

	                      }
	                 // findOperation(l1,queries.get(i));
	             }
	             
	             //findOperation(l1,queries.get(i));
	        
	        return l1;
	}
	    

	static void findOperation(List<Integer> l1, List<Integer> l2) {
		if (l2.get(0) == 1)

		{
			int key = l2.get(1);
			if (m1.containsKey(key)) {
				m1.put(key, m1.get(key) + 1);
			} else
				m1.put(key, 1);
		}
		if (l2.get(0) == 2) {
			int key = l2.get(1);

			if (m1.containsKey(key)) {
				if (m1.get(key) == 1)
					m1.remove(key);
				else if (m1.get(key) > 1)
					m1.put(key, m1.get(key) - 1);
			}

		}
		if (l2.get(0) == 3) {
			int value = l2.get(1);
			
			if(m1.size()==0)
			{
				l1.add(0);
				return;
			}
			for (Map.Entry<Integer, Integer> e1 : m1.entrySet()) {
				int freq = e1.getValue();
				if (freq == value)
				{
					l1.add(1);
					break;
				}
				else
				{
					l1.add(0);
					break;
					
				}
			}
		}

	}

	// private static Map<Integer,String> m1=null;

	public static void main(String[] args) {
		
	/*	m1=new HashMap<Integer,String>();
		
		
		m1.put(3, "a");
		m1.put(1, "b");
		m1.put(5, "c");
		m1.put(4, "d");
		m1.put(10, "e");
		m1.re
	   m1.put(null, "1");	
	   System.out.println(m1.remove(3));
		System.out.println(m1.get(null));
		TreeMap<Integer,String> t1=new TreeMap<Integer,String>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
		
			return (o1.compareTo(o2));
			}
			
		});
		t1.putAll(m1);
		
		
		System.out.println(t1);
		
		
		Iterator i1=m1.entrySet().iterator();
		
		for(Map.Entry<Integer, String> entry:m1.entrySet())
			System.out.println(entry.getKey());
	}*/

}
}
