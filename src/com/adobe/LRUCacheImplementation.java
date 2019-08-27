package com.adobe;

import java.util.HashMap;

class CacheNode{
  
	int key;
	int value;
	CacheNode next;
	CacheNode prev;
	
	public CacheNode(int key, int value) {
		this.key=key;
		this.value=value;
		
	}
	
}
public class LRUCacheImplementation {

	int capacity;
	HashMap<Integer,CacheNode> h1=new HashMap<>();
	CacheNode head=null;
	CacheNode end=null;
	
	public LRUCacheImplementation( int capacity) {
		this.capacity=capacity;
	}
	
	public void set(int key,int value)
	{
		if(h1.containsKey(key))
		{
			CacheNode old=h1.get(key);
			old.value=value;
			delete(old);
			setHead(old);
		}
		else
		{
			CacheNode newCacheNode=new CacheNode(key,value);
			if(h1.size()>=capacity)
			{
				h1.remove(end.key);
				delete(end);
				setHead(newCacheNode);
			}
			else {
		    setHead(newCacheNode);
			}
			h1.put(key, newCacheNode);

		}

	}
	private void setHead(CacheNode old) {
         old.next=head;
         old.prev=null;
		
		if(head!=null)
		   head.prev=old;
			head=old;
		if(end==null)
			end=old;
		
		
			}

	private void delete(CacheNode old) {

		if(old.prev==null)
		{
			head=old.next;
		}
		else
			old.prev.next=old.next;
		if(old.next!=null)
		{
			old.next.prev=old.prev;
		}
		else
			end=old.prev;
	}

	public static void main(String[] args) {

		LRUCacheImplementation l1= new LRUCacheImplementation(4);
		l1.set(1, 100);
		l1.set(10, 99);
		l1.set(15, 98);
		l1.set(10, 97);
		l1.set(12, 96);
		l1.set(18, 95);
		l1.set(1, 94);
 
		System.out.println(l1.get(1));
		System.out.println(l1.get(10));
		System.out.println(l1.get(15));
 

	}

	private int get(int i) {
		
		if(h1.containsKey(i))
		{
			CacheNode n1= h1.get(i);
			delete(n1);
			setHead(n1);
			return n1.value;
			
		}
		return 0;
		
	}

}
