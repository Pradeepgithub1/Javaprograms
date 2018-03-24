
package com.bridgeit.datastructure;
public class circularQueue {
	int top=0,rear=-1;
	static int count;
	static int size=5;
	int queue[]=new int[size];
	public void insert(int data)
	{
		if(count==size)
		{
			System.out.println("Queue is full");
		}
		else
		{
			count++;
			rear=(rear+1)%size;
			queue[rear]=data;

		}
	}
	public void delete(int data) throws Exception
	{
		if(count==0)
		{
			throw new Exception();
		}
		else
		{
			System.out.println(" person deleted from the queue");
			top=(top+1)%size;
			count--;
		}
	}
	public int size()
	{		return size-count;
	}


}