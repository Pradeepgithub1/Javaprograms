/***********************************************************************************
 * Purpose:flip coin finding the head% and tail%
 * 
 * @author bridgeit
 * 
 * Date: 22/02/18
 ***********************************************************************************/
package com.bridgeit.functional_programs;
import com.bridgeit.utility.Utility;
public class FlipCoin {
	static int tail,head;
	public static void main(String args[])
	{
		Utility utility=new Utility();
		System.out.println("The number of times to Flip Coin");
		int number=utility.IntegerInput();
		boolean isNonZeroNum=utility.isNonZeroNumber(number);

		if(isNonZeroNum)
		{
			for(int i=1;i<number;i++)
			{
				double randomNumber=Math.random();
				if((randomNumber>0)&&(randomNumber<0.5))
				{
					tail++;
				}
				else if((randomNumber>0.5)&&(randomNumber<1))
				{
					head++;
				}

			}
		}
		else
			System.out.println("Enter the the value grater than 0");

		System.out.println("Head%="+" "+(head*100)/number);
		System.out.println("Tail%="+" "+(tail*100)/number);

	}

}
