/**************************************************************************************************************************
 * Purpose:Baking implimentations
 * 
 * @author bridgeit
 * 
 * Date: 22/02/18
 **************************************************************************************************************************/
package com.bridgeit.datastructure;
import java.util.ArrayDeque;

import com.bridgeit.utility.Utility;

public class CallenderUsingQueue {
@SuppressWarnings({ "unchecked", "rawtypes" })
public static void main(String[] args) {
	Utility utility=new Utility();
	
	int month = utility.IntegerInput();
	int year = utility.IntegerInput();
	String[] months = {
			"",                             
			"January", "February", "March",
			"April", "May", "June",
			"July", "August", "September",
			"October", "November", "December"
	};
	int[] days = {
			0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};


	if (month == 2 && utility.LeapYear(year)) days[month] = 29;

	//
	int d = utility.day(month, 1, year);
     UserDefinedLinkedList userLinkedList[]=new UserDefinedLinkedList[5];
     int count=0;
	for (int i = 0; i < d; i++)
	{
		userLinkedList[count].add("");
	}
	for (int i = 1; i <= days[month]; i++) 
	{
		userLinkedList[count].add(i);
		if (((i + d) % 7 == 0) || (i == days[month]))
		{
		     count++;
		}
	}
	ArrayDeque queue=new ArrayDeque();
	for(int i=0;i<5;i++)
	{
	
		userLinkedList[i].addToQueue(queue);
	}
	System.out.println("      " +months[month] +" " +year  );
	System.out.println(" S  M Tu  W Th  F  S");
	 
    

}
}
