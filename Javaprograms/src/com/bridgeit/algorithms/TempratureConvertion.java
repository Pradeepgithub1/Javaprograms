package com.bridgeit.algorithms;

import java.util.Scanner;

import com.bridgeit.algorithms.utility.Utility1;

public class TempratureConvertion {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Utility1 utility=new Utility1();
		while(true)
		{
				System.out.println("\t\t--:Temprature Convertion:--\t");
				System.out.println("\t\t1:Celsius to Fahrenheit\t"+"Enter------ >CTF");
				System.out.println("\t\t1:Fahrenheit to Celsius\t"+"Enter------->FTC");
				String choice=scanner.next();
				
			if(choice.equals("CTF"))
			{
					System.out.println("\tEnter temperature in celsius");
					int input=scanner.nextInt();
					@SuppressWarnings("static-access")
					int result=utility.temperaturConversion(input,choice);
					System.out.println("\ttemperature in Fahrenheit"+result);
			}
			else if(choice.equals("FTC"))
			{
					System.out.println("\tEnter temperature in Fahrenheit");
					int input=scanner.nextInt();
					@SuppressWarnings("static-access")
					int result=utility.temperaturConversion(input,choice);
					System.out.println("\ttemperature in Celsius"+result);
			}
			else
			{
					System.out.println("\t\t\tThank You\t\t");
					break;
			}
		}
	}

}
