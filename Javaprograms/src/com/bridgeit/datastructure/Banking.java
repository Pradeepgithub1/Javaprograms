/**************************************************************************************************************************
 * Purpose:Baking implimentations
 * 
 * @author bridgeit
 * 
 * Date: 22/02/18
 **************************************************************************************************************************/
package com.bridgeit.datastructure;
import com.bridgeit.utility.Utility;
public class Banking {
	static Utility utility=new Utility();
	private static int balence=100000;
	
		public static int getBalence(){
			return balence;
		}
		
		public static void updateBalenceAfterDeposit(int ammount){  balence=balence+ammount;
		}
		
		public static void updateBalenceAfterWithdraw(int ammount){  balence=balence-ammount;
		}
		
 @SuppressWarnings("static-access")
public static void main(String args[])
	 {  
	 
		while(true)
		{
			
		  circularQueue uq=new circularQueue();
		  System.out.println("\t\t------:Bank cash counter:--------");
		  System.out.println("\t1:Deposite");
		  System.out.println("\t2:Withdraw");
		  System.out.println("\t3:Number of peoples in the queue");
		  System.out.println("\t4:Enter the Number of peoples in to the queue");
		  System.out.println("enter any key to exit");
		  System.out.println("enter your choice");
		  int choice=utility.IntegerInput();

		  switch(choice)
			   {
		  
			 case 1: 	System.out.println("enter the ammount to deposite");
			 			int depositeAmmount=utility.IntegerInput();
			 			uq.insert(depositeAmmount);
			 			Banking.updateBalenceAfterDeposit(depositeAmmount);
			break;
			
			case 2:     System.out.println("enter the ammount to withdraw");
					try {
				
							int withdrawAmmount=utility.IntegerInput();
							uq.delete(withdrawAmmount);
							Banking.updateBalenceAfterWithdraw(withdrawAmmount);
							System.out.print("Avalable balence is: ");
							System.out.println(Banking.getBalence());
							
						}
					catch (Exception e) 
					{
		
						System.out.println("No peoples in the Queue");
					}
			break;
			
			case 3:	 System.out.println("Number of peoples in the queue "+uq.size());
			break;
			
			case 4: uq.size=(utility.IntegerInput());
			System.out.println(uq.size+" peoples added to the queue");
			break;
			
			default: System.exit(0);
			
		  }
		  
	   }
		
   }
 
}
