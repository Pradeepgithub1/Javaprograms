/*************************************************************************************************************************************************
 *  Purpose: Reading numbers from the file,sorting the numbers 
 *           searching if word found then remove it else add to list
 *
 *  @author  bridgeit
 * 
 *  Date:    1/03/18
 *
 ************************************************************************************************************************************************/
package com.bridgeit.datastructure;
import java.util.Arrays;
import com.bridgeit.utility.Utility;
public class OrderedLinkedList {
	private static String[] stringArray;

	public static void main(String args[]) throws Exception
	{
		Utility utility=new Utility();
		UserDefinedLinkedList<String> ll=new UserDefinedLinkedList<String>();
		stringArray=utility.fileReading();
		System.out.println("After sorting--");
		Arrays.sort(stringArray);
		ll.disply();
		for(int i=0;i<stringArray.length;i++)
		{
			ll.add(((stringArray[i])));
		}
		ll.disply();
		System.out.println();
		System.out.println();
		while(true)
		{
			System.out.println("Enter the key element to search");
			String key = utility.StringInput();
			boolean result=ll.search(key);
			if(result)
			{
				System.out.println("Element found");
				ll.remove(key);
			}
			else
			{
				ll.add(key);
				System.out.println("Key"+" "+key+" "+"Not found");
			}
			ll.disply();
			utility.filewriting(ll);
		}
	}

}
