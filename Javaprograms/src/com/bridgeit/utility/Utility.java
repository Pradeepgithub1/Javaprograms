package com.bridgeit.utility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.datastructure.UserDefinedDeQueue;
import com.bridgeit.datastructure.UserDefinedLinkedList;
import com.bridgeit.datastructure.UserDefinedStack;
import com.bridgeit.functional_programs.CouponNumber;


public class Utility {
	PrintWriter mWriter=new PrintWriter(System.out,true);
	public static Scanner scanner;
	Scanner scan=new Scanner(System.in);
	/**take user name and check it matches with given pattern or not
	 * @param userName
	 * @return Yes or No
	 */
	public boolean userName(String userName) {
		if(Pattern.matches("[A-B]{1}[a-z\\D]{4,15}",userName)) {
			return true;
		}
		else
			return false;
	}
	/****************************************************************************************/
	/**Prints power of 2
	 * @param Number
	 */
	public  void powerOf2Print(int Number)
	{
		for(int i=0;i<Number;i++)
		{
			double pow=Math.pow(2, i);
				System.out.println((int)pow);
		}
	}


	/**This method will Check weather Number is Non zero or not 
	 * @param number
	 * @return NonZero or Not
	 */
	public boolean isNonZeroNumber(double number)
	{
		if(number!=0)
			return true;
		else
			return false;
	}


	/**This method will check the number is four digit or not
	 * @param number
	 * @return NonZero Or Not
	 */
	public boolean isFourDigitNumber(int number)
	{
		if((number>999)&&(number<99999))
			return true;
		else
			return false;
	}


	/**
	 * @param year
	 * @return LeapYear or Not
	 */
	public boolean cheakLeapYear(int year)
	{
		if(((year%4==0)&&(year%100!=0))||(year%400==0))
			return true;
		else
			return false;
	}


	/**This method will take N as a Number and prints Nth Harmonics 
	 * @param number
	 * @return harmonicsum
	 */
	public double harmonicSum(int number)
	{
		double sum=0;
		for(int i=1;i<=number;i++)
		{
			sum=sum+((1.0)/i);
		}
		return sum;
	}


	/**This method will take number
	 * and prints its primeFacters
	 * @param number
	 */
	public  void primeFactors(int number)
	{
		while(number%2==0)
		{
			System.out.println(2);
			number=number/2;
		}
		for(int i=3;i*i<=number;i=i+2)
		{
			while(number%i==0)
			{
				System.out.println(i);
				number=number/i;
			}
		}
		if(number>=2)
		{
			System.out.println(number);
		}
	}


	/**This method will take Number as a length of array and read elements into Array 
	 * @param number
	 * @return Array with elements
	 */
	public  int[] input(int number)
	{
		int a[]=new int[number];
		for(int i=0;i<number;i++)
		{
			a[i]=scan.nextInt();
		}
		return a;
	}


	/**this method will take Array and its length and Prints the Triplets whose sum==0
	 * @param a
	 * @param number
	 */
	public void tripletPrint(int a[],int number)
	{
		int tripletCoun=0;
		for(int i=0;i<number;i++)
		{
			for(int j=i+1;j<number-1;j++)
			{
				for(int k=j+1;k<number-2;k++)
				{
					if(a[i]+a[j]+a[k]==0)
					{
						System.out.println(a[i]+" "+a[j]+" "+a[k]);
						tripletCoun++;
					}
				}
			}
		}
		System.out.println(tripletCoun);
	}


	/**This method will calculate EuclideanDistance
	 * @param x
	 * @param y
	 * @return Distance
	 */
	public double EuclideanDistance(int x,int y)
	{
		int a=x;
		int b=y;
		long result=(a*a)+(b*b);
		double distance=Math.sqrt(result);
		return distance;

	}

	/**this method will check the condition to start and stop of StopWatch
	 * @param choice
	 * @return true or false
	 */
	public boolean conditionCheck(String choice)
	{
		if(choice=="'start'")
			return true;
		else if(choice=="'stop'")
			return true;
		else
			return false;
	}
	/**this method will compute b^2-4*a*c
	 * @param a
	 * @param b
	 * @param c
	 * @return (b*b-4*a*c)
	 */
	public double Compute(int a,int b,int c)
	{
		double result=(b*b-(4*a*c));
		return result;
	}


	/**
	 * @param temparature
	 * @param windSpeed
	 * @return converted Temperature
	 */
	public double computeWindChill(int temparature,int windSpeed)
	{

		double result=(35.74+.6215*temparature)+(((0.4275*temparature)-35.77)*Math.pow(windSpeed,0.16));
		return result;
	}


	/**
	 * @param row
	 * @param col
	 * @return int array
	 */
	public int[][] readInput(int row,int col)
	{
		int a[][]=new int[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				a[i][j]=scan.nextInt();
			}
		}
		return a;
	}
	/**
	 * @param string
	 * @param low
	 * @param high
	 * @return String
	 */
	public String swap(String string,int low,int high)
	{
		char a[]=string.toCharArray();
		char temp=a[low];
		a[low]=a[high];
		a[high]=temp;
		return String.valueOf(a);
	}
	/**
	 * @param string
	 * @param low
	 * @param high
	 * @return String
	 */
	public String permute(String string,int low,int high)
	{
		if(low==high)
		{
			System.out.println(string);
		}
		else
		{
			for(int i=low;i<=high;i++)
			{
				string=swap(string,low,i);
				permute(string,low+1,high);
				string=swap(string,low,i);
			}
		}
		return string;

	}

	/**
	 * @param number
	 * @return integer
	 */
	public  int generateCouponNumber(int number) {
		int mRanCountr=0;
		ArrayList al=new ArrayList();
		for(int i=1;i<=number;i++)
		{
			long newRandomNum=randomeNumberGenerater();
			if(al.contains(newRandomNum))
			{
				mRanCountr++;
			}
			else
			{
				al.add(newRandomNum);
				mRanCountr++;
			}
		}
		System.out.println(al);
		return mRanCountr;
	}
	/**
	 * @param userName
	 * @param GIVENPATTERN
	 * @return String
	 */
	public String  replacing(String userName, String GIVENPATTERN) {
		String newPattern=GIVENPATTERN.replaceAll("<<Username>>", userName);
		return newPattern ;
	}
	public static long randomeNumberGenerater() {
		Random ran=new Random();
		long randomNum=ran.nextInt(100000000);
		return randomNum;
	}

	public static int[] integerInput() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the lenth of array");
		int number = scan.nextInt();

		int array[] = new int[number];
		System.out.println("enter your elements");
		for (int i = 0; i < number; i++) {
			array[i] = scan.nextInt();
		}
		return array;
	}

	/************************************************************************************/
	/**
	 * Method for String input
	 * 
	 * @return
	 */
	public static String[] stringInput() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the lenth of array");
		int number = scan.nextInt();

		String array[] = new String[number];
		System.out.println("enter your elements");

		for (int i = 0; i < number; i++) {
			array[i] = scan.next();
		}
		return array;
	}

	/************************************************************************************/
	public void BinarySearchForSting() {

		String array[] = stringInput();
		int length = array.length;

		System.out.println("enter the key to search");
		String key = scan.next();

		Arrays.sort(array);

		boolean flag = binarySearch(array, 0, length - 1, key);

		if (flag) {
			System.out.println("Element found");
		} else {
			System.out.println("Element not found");
		}

	}

	/***************************************************************/

	public boolean binarySearch(String[] array, int low, int high, String key) {

		if (low == high) 
		{
			if (array[low].compareTo(key)==0)
				return true;
			else
				return false;
		}

		else {

			if (low <= high)
			{

				int mid = (low + high) / 2;

				if (array[mid].compareTo(key) == 0)
				{
					return true;
				}

				else if (array[mid].compareTo(key) > 0)
				{
					return binarySearch(array, mid +1,high, key);
				}

				else 
				{
					return binarySearch(array, low, mid-1, key);
				}

			}
			return false;

		}

	}

	/***********************************************************************************/
	public void BinarySearchForInteger() {

		int array[] = integerInput();
		int length = array.length;
		System.out.println("enter the key to search");
		int key = scan.nextInt();

		Arrays.sort(array);

		boolean flag = binarySearch(array, 0, length - 1, key);

		if (flag) {
			System.out.println("Element found");
		} else {
			System.out.println("Element not found");
		}

	}

	/**************************************************************************************/

	public boolean binarySearch(int[] array, int low, int high, int key) {

		if (low == high) {
			if (array[low] == key)
				return true;
			else
				return false;
		}

		else {

			if (low <= high) {

				int mid = (low + high) / 2;

				if (array[mid] == key) {
					return true;
				}

				else if (array[mid] > key) {
					return binarySearch(array, low, mid - 1, key);
				}

				else {
					return binarySearch(array, mid + 1, high, key);
				}

			}
			return false;

		}

	}

	/**********************************************************************************/

	public void insertionSortForInteger() {
		int array[] = integerInput();
		int length = array.length;
		for (int i = 0; i < length; i++) {
			int key = array[i];
			int j = i - 1;
			while ((j >= 0) && (array[j] > key)) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
		System.out.println("Elements ofter insertion sort");
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	/************************************************************************************/
	public void insertionSortForString() {
		String array[] = stringInput();
		int length = array.length;
		for (int i = 0; i < length; i++) {
			String key = array[i];
			int j = i - 1;
			while ((j >= 0) && (array[j].compareTo(key) > 0)) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
		System.out.println("Elements ofter insertion sort");
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}

	}
	public int[][] takeInput(int m,int n)
	{
		int twoDArray[][]=new int[m][n];	

		System.out.println("enter the elements");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				twoDArray[i][j]=IntegerInput();
			}
		}
		return twoDArray;
	}
	public void print(int twoDArray[][],int m,int n )
	{

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				mWriter.print(twoDArray[i][j]+" ");
				mWriter.flush();
			}
			System.out.println();
		}
	}

	/**********************************************************************************/
	public void bubleSortForString() {
		String array[] = stringInput();
		int length = array.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {

				if ((array[j].compareTo(array[j + 1])) > 0) {
					String temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println("Elements ofter buble sort");
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	/********************************************************************************/
	public void bubleSortForInteger() {
		int array[] = integerInput();
		int length = array.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println("Elements ofter buble sort");
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * @param string2)
	 * @param string1
	/ ******************************************************************************/
	public boolean anagram(String string1, String string2) {
		char[] char1 = string1.toCharArray();
		char[] char2 = string2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);

		String anagram1 = String.valueOf(char1);
		String anagram2 = String.valueOf(char2);

		if (anagram1.equals(anagram2))
			return true;
		return false;
	}

	/**
	 * this method is check the prime numbers are anagrams or not
	 * 
	 */
	/*********************************************************************************/
	public void primeAndAnagram() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("2");
		al.add("3");
		int count = 0;
		for (int i = 4; i <= 1000; i++) {
			count = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					count++;
					break;
				}
			}
			if (count == 0) {
				al.add(Integer.toString(i));
			}

		}
		System.out.print("Prime numbers:");
		System.out.println(al);
		String[] strArray = new String[al.size()];
		strArray = al.toArray(strArray);
		System.out.println("**************************************");		
		System.out.println("Prime numbers that are Anagrams:");
		for (int i = 0; i < strArray.length; i++) {
			for (int j = i + 1; j < strArray.length; j++) {
				if (anagram(strArray[i], strArray[j])) {
					System.out.println(strArray[i] + "->" + strArray[j]);
				}
			}
		}
		System.out.println();
		System.out.println("Prime numbers that are Palendroms:");

		for (int i = 0; i < strArray.length; i++) 
		{
			String temparary=new StringBuffer(strArray[i]).reverse().toString();
			if(temparary.equals(strArray[i]))
			{
				System.out.print(strArray[i]+" ");
			}
		}
	}
	/**
	 * @return ************************************************************************/

	public static int vendingMachine(int ammount) {
		int ammountCount = 0;
		while(ammount>0)
		{
			if(ammount>=1000)
			{
				ammountCount=ammountCount+ammount/1000;
				System.out.println("Nouber of 1000 Rupes Notes: "+ammount/1000);
				ammount=ammount%1000;
			}
			else if(ammount>=500)
			{
				ammountCount=ammountCount+ammount/500;
				System.out.println("Nouber of 500 Rupes Notes: "+ammount/500);
				ammount=ammount%500;
			}
			else if(ammount>=100)
			{
				ammountCount=ammountCount+ammount/100;
				System.out.println("Nouber of 100 Rupes Notes: "+ammount/100);
				ammount=ammount%100;
			}
			else if(ammount>=20)
			{
				ammountCount=ammountCount+ammount/20;
				System.out.println("Nouber of 20 Rupes Notes: "+ammount/20);
				ammount=ammount%20;
			}
			else if(ammount>=10)
			{
				ammountCount=ammountCount+ammount/10;
				System.out.println("Nouber of 10 Rupes Notes: "+ammount/10);
				ammount=ammount%10;
			}
			else if(ammount>=5)
			{
				ammountCount=ammountCount+ammount/5;
				System.out.println("Nouber of 5 Rupes Notes: "+ammount/5);
				ammount=ammount%5;
			}
			else if(ammount>=2)
			{
				ammountCount=ammountCount+ammount/2;
				System.out.println("Nouber of 2 Rupes Notes: "+ammount/2);
				ammount=ammount%2;
			}
			else if(ammount>=1)
			{
				ammountCount=ammountCount+ammount/1;
				System.out.println("Nouber of 1 Rupes Notes: "+ammount);
				ammount=ammount%1;
			}
		}
		return ammountCount;
	}
	public static int temperaturConversion(int input,String choice)
	{
		if(choice=="CTF")
		{
			int CTF=input*(9/5)+32;
			return CTF;
		}
		else if(choice=="FTC")
		{
			int FTC=(input-32)*9/5;
			return FTC;
		}
		else
			return 0;


	}

	public String tobinary(int decimalInput) {

		if(decimalInput==0)
			return "0";
		else
		{
			String result=" ";
			while(decimalInput>0)
			{
				if(decimalInput%2==0)
				{
					result="0"+result;
				}
				else if(decimalInput%2!=0)
				{
					result="1"+result;
				}
				decimalInput=decimalInput/2;
			}
			return "0"+result;
		}

	}

	public double sqrtUsingNewtonsMethod(double number) {
		double newNumber=number;
		double epsilon=1E-15;
		while((Math.abs(newNumber-number/newNumber)>epsilon*newNumber))
		{
			newNumber=((number/newNumber)+newNumber)/2.0;
		}
		return newNumber;

	}

	public double monthlyPayment(double p, double rateOfInterst, int y) {
		double n=12*y;
		double r1=rateOfInterst/(12*100);
		double payment;
		double a=1-Math.pow((1+r1),-n);
		payment=(p*r1/(1-a));
		return payment;
	}
	public Utility()
	{
		scanner=new Scanner(System.in);
	}
	public double doubleInput1() {
		try {
			return scanner.nextDouble();

		} catch (Exception e) {

		}
		return 0;
	}
	public int IntegerInput() {
		try {
			return scanner.nextInt();

		} catch (Exception e) {

		}
		return 0;
	}public String StringInput() {
		try {
			return scanner.next();

		} catch (Exception e) {

		}
		return "";
	}
	public String StringLineInput() {
		try {
			scanner.nextLine();
			return scanner.nextLine();

		} catch (Exception e) {

		}
		return "";}public long dInput() {
			try {
				return scanner.nextLong();

			} catch (Exception e) {

			}
			return 0;
		}
		public boolean booleanInput() {
			try {
				return scanner.nextBoolean();

			} catch (Exception e) {

			}
			return false;
		}
		void merge(String[] array, int low, int mid, int high)
	    {
	        int n1 = mid - low + 1;
	        int n2 = high - mid;
	         String leftArray[] = new String [n1];
	        String rightArry[] = new String [n2];
	 
	        for (int i=0; i<n1; ++i)
	            leftArray[i] = array[low + i];
	        for (int j=0; j<n2; ++j)
	            rightArry[j] = array[mid + 1+ j];
	        int i = 0, j = 0;
	         int k = low;
	        while (i < n1 && j < n2)
	        {
	            if (leftArray[i].compareTo(rightArry[j])<=0)
	            {
	                array[k] = leftArray[i];
	                i++;
	            }
	            else
	            {
	                array[k] = rightArry[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1)
	        {
	            array[k] = leftArray[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            array[k] = rightArry[j];
	            j++;
	            k++;
	        }
	    }
		    public void sort(String[] array, int low, int high)
		    {
		        if (low < high)
		        {
		            int m = (low+high)/2;
		             sort(array, low, m);
		            sort(array , m+1, high);
		             merge(array, low, m, high);
		        }
		    }

	    public static void printArray(String arr[])
	    {
	        int n = arr.length;
	        System.out.println("\t\t\t");
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	    
public void cashCounter(int cash1, int people1) {
		int customerNo = 0;
		int cash = cash1;
		int people = people1;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < people; i++) {
			queue.add(i);
		}
		for (int i = 0; i < people; i++) {
			System.out.println();
			customerNo++;
			System.out.print("Person no. " + customerNo + " :\n");
			queue.remove();
			System.out.print("\t\t\t===>1.CashWithdrawal===>\n\t\t\t===>2.Deposit===>\n");
			int choice = scanner.nextInt();
			cash = transaction(choice, cash);
			System.out.println();
			System.out.print("\t\t\tTotal cash balance  is : " + cash+"\n");
		}
		if (customerNo == people)
			System.out.println();
		System.out.println("End of queue..\n");
	}
			
		private int transaction(int choice1, int cash1)
		{
			int choice = choice1;
			int cash = cash1;
			switch (choice) {
			case 1:
				if (cash <40) {
					System.out.println("\t\t\tEnter the cash Minimum of 50");
					break;
				}
				System.out.println("\t\t\tEnter the ammount  to withdraw..??");
				int withdrawalAmount = scanner.nextInt();
				if (cash >= withdrawalAmount) {
					cash =cash- withdrawalAmount;
					System.out.println("\t\t\tTransaction of amount " + withdrawalAmount + " was Successful");
					return cash;
				} else {
					System.out.println("\t\t\tSorry...!!Insufficient balence.!!");
					break;
				}
			case 2:
				System.out.println("\t\t\tEnter the Deposite ammount");
				int depositAmount = scanner.nextInt();
				cash =cash+ depositAmount;
				System.out.println("Deposited " + depositAmount + " Successfully");
				return cash;

			default:
				System.out.println("Invalid choice");
				break;
			}
			return cash;
}
		String hasingFile1="/home/bridgeit/myPrograms/Javaprograms/src/com/bridgeit/algorithms/input.text";
		@SuppressWarnings("resource")
		public String[] fileReading() throws IOException {
			
			BufferedReader bufferedReader = null;
			bufferedReader = new BufferedReader(new FileReader(hasingFile1));

			String lines = null;
			lines = bufferedReader.readLine();

			System.out.println("------>" + lines);

			String[] stringArray = lines.split(" ");
			return stringArray;
		}
		String hasingFile="/home/bridgeit/file/HashingFun.txt";
        public String[] hashinFileReading() throws IOException {
			
			BufferedReader bufferedReader = null;
			bufferedReader = new BufferedReader(new FileReader(hasingFile));

			String lines = null;
			lines = bufferedReader.readLine();

			System.out.println("------>" + lines);

			String[] stringArray = lines.split(" ");
			return stringArray;
		}
	
		public void filewriting(UserDefinedLinkedList ll) throws IOException {
			System.out.println();
			String file="/home/bridgeit/file/orderedList.txt";
			FileWriter fileWriter = new FileWriter(file);
			  BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			  System.out.println("Updated data: "+ll.toString());
			  bufferedWriter.write(ll.toString());
			  bufferedWriter.flush();
			  bufferedWriter.close();
		}

		public String isBalenced(String expstion )
		{

			UserDefinedStack stack=new UserDefinedStack();
			int i=0;
			char ch=' ';
			char charArray[]=expstion.toCharArray();
			for(i=0;i<expstion.length();i++)
			{
				ch=charArray[i];
				if(ch=='['||ch=='('||ch=='{')
				{
					stack.push(ch);
				}
				else if((ch==']'||ch==')'||ch=='}')&&(!stack.isEmpty()))
				{
					if(((char)stack.peek()=='('&&ch==')')||((char)stack.peek()=='['&&ch==']')||((char)stack.peek()=='{'&&ch=='}'))
					{
						stack.pop();
					}
					else
					{
						System.out.println((ch-1)+" mismatched at index "+i);
						break;
					}
				}
				else
				{
					if((ch==']'||ch==')'||ch=='}'))
					{
						System.out.println(ch+" mismatched at index "+i);
						break;
					}
				}
			}
			if(stack.isEmpty())
			{
				return "Balenced paranthesiss";
			}
			else
			{
				char c=(char) stack.pop();
				while(!stack.isEmpty())
				{

					if((i>=0&&i<expstion.length())&&(expstion.charAt(i)==c))
					{
						i--;
						System.out.println(c+" mismatched at index "+i);
						c=(char) stack.pop();

					}
					else
					{
						i--;
					}
				}
				System.out.println(ch+" mismatched at index "+i);
				return "Not Balenced";
			}
		}
		public void hasingImplimentation(String[] string)
		{
			Utility utility = new Utility();
			HashMap<Integer, OrderList> map = new HashMap<Integer, OrderList>();
			int rem = -1;
			for (int i = 0; i < string.length; i++) {
				rem = Integer.parseInt(string[i]) % 11;
				if (map.containsKey(rem)) {
					OrderList list = map.get(rem);
					list.insert(Integer.parseInt(string[i]));
				} else {
					map.put(rem, new OrderList());
					OrderList list = map.get(rem);
					list.insert(Integer.parseInt(string[i]));
				}
		}

			System.out.println(map);
			System.out.print("Elements persent in the File  : ");
			for (String str : string) {
				System.out.print(str + " ");
			}
			System.out.println();

			System.out.print("Enter the Key Which you want  : ");
			int key = utility.IntegerInput();
			// int index = 0;
			rem = key % 11;

			if (map.containsKey(rem)) {
				OrderList list = map.get(rem);

				if (list.search(key)) {
					list.remove(key);
					System.out.println(key + " Found and removed from the list...!");
					fileUpdate(map);
					System.out.println("File is Update...!");
				} else {
					list.add(key);
					System.out.println(key + " Not Found and added from the list...!");
					fileUpdate(map);
					System.out.println("File is Update...!");
				}
			} else {
				map.put(rem, new OrderList());
				OrderList list = map.get(rem);
				if (!list.search(key)) {
					list.add(key);
					System.out.println(key + " Not Found and added from the list...!");
					fileUpdate(map);
					System.out.println("File is Update...!");
				}
			}
		}
		public static void fileUpdate(HashMap<Integer, OrderList> map) {
			try {
				String string = map.toString();
				System.out.println(string);
				FileWriter fw = new FileWriter("/home/bridgeit/file/HasingStore.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(string);
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public int primeCount() {
			System.out.println("enter the frist");
			int first=IntegerInput();
			System.out.println("enter the last");
			int last=IntegerInput();
			int count=0;
			boolean flag=true;
			for(int i=first;i<=last;i++)
			{
				for(int j=2;j<i;j++)
				{
					if(i%j==0)
					{
						flag=false;
						break;
					}
					flag=true;
				}
				if(flag)
					count++;
			}
			System.out.println("Prime numbers from "+first+" to " +last+": " +count);
			return count;
		}
		public ArrayList<Integer> primeNumbers()
		{

			boolean flag=true;
			ArrayList<Integer>al=new ArrayList<Integer>();
			for(int i=0;i<1000;i++)
			{
				for(int j=2;j<i;j++)
				{
					if(i%j==0)
					{
						flag=false;
						break;
					}
					flag=true;
				}
				if(flag)
				{
					al.add(i);
				}
			}

			return al;


		}
		public int [][] createTwoDArray()
		{
			int array[][]=new int [10][];
			for(int i=0;i<10;i++)
			{
				int m=primeCount();
				array[i]=new int[m];
			}

			return array;

		}
		public void printPrimeNumbersIn2DArray(ArrayList<Integer> al, int[][] array) {
			Iterator<Integer>itr=al.iterator();

			System.out.println();
			System.out.println("\t\t\t\t-----------------------------------Prime Numbers in 2D Array---------------------------------------");
			while(itr.hasNext())
			{
				for(int i=0;i<10;i++)
				{
					for(int j=0;j<array[i].length;j++)
					{
						array[i][j]=itr.next();
						System.out.print("\t"+array[i][j]+" ");
					}
					System.out.println();
				}
			}

		}
		@SuppressWarnings("unchecked")
		public int[] primeAnagrams(ArrayList<Integer> al)
		{

			@SuppressWarnings("rawtypes")
			ArrayList al1=new ArrayList();
			Object[] array=al.toArray();
			for(int i=0;i<array.length;i++)
			{
				for(int j=i+1;j<array.length;j++)
				{
					if(anagram(String.valueOf(array[i]),String.valueOf(array[j])))
					{
						al1.add(array[i]);
						//al1.add(array[j]);
					}
				}
			}
			int newArray[]=new int[al1.size()];
			@SuppressWarnings("unchecked")
			Iterator<Integer>itr=al1.iterator();
			while(itr.hasNext())
			{
				for(int i=0;i<newArray.length;i++)
				{
					newArray[i]=itr.next();
				}
			}

			return newArray;


		}
		public void printAnagramInTwoD(int[] newArray)
		{
			int k=0;
			int twoDArray[][]=new int[9][9];
			try {
				for(int i=0;i<9;i++)
				{
					for(int j=0;j<9;j++)
					{
						 if(k==79)
						break;

						twoDArray[i][j]=newArray[k];
						k++;
						System.out.printf(twoDArray[i][j]+" ");
					}
					System.out.println();
				}
			}
			catch (Exception e) {
				System.out.println();
				System.out.println("Prime Numbers that are anagrams stored in 2D Array");
			}
		}
		public int[] primeAnagrams() {
			int array[]=new int[1000];	
			System.out.println("enter the frist");
			int first=IntegerInput();
			System.out.println("enter the last");
			int last=IntegerInput();
			int count=0;
			boolean flag=true;
			int k=0;
			for(int i=first;i<=last;i++)
			{
				for(int j=2;j<i;j++)
				{
					if(i%j==0)
					{
						flag=false;
						break;
					}
					flag=true;
				}
				if(flag)
				{
					array[k]=k;
					k++;
				}

			}
			System.out.println("Prime numbers from "+first+" to " +last+": " +count);
			return null;
		}
		public boolean isPrime(int i)
		{
			boolean flag=true;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					flag=false;
					break;
				}
				flag=true;
			}
			if(flag)
				return true;
			else
				return false;
		} 
		public  int day(int month, int day, int year)
		{
			int y = year - (14 - month) / 12;
			int x = y + (y/4) - (y/100) + (y/400);
			int m = month + 12 * ((14 - month) / 12) - 2;
			int d = (day + x + ((31*m)/12)) % 7;
			return d++;
		}
		public  boolean LeapYear(int year) 
		{
			if  ((year % 4 == 0) && (year % 100 != 0)) return true;
			if  (year % 400 == 0) return true;
			return false;
		}
		public int[] binaryConvertion(int number) {

			System.out.println("enter the number of bits");
			int numberOfBits=IntegerInput();
			int array[]=new int[numberOfBits];
			int count=0;
			while(numberOfBits!=0)
			{
				array[count]=number%2;
				number=number/2;
				count++;
				numberOfBits--;
			}
			return array;
		}
		public int findNumber(int low, int high) {
			if(high-low==0)
				return high;
			else
			{
				int mid=(high+low)/2;
				System.out.println("is your number is in between"+low+"  to "+mid);
				if(scanner.nextBoolean())
				{
					return findNumber(low,mid);
				}
				else
				{
					return findNumber(mid+1,high);
				}

			}
		}
		@SuppressWarnings("unchecked")
		public void setData() {
			int weight=0,price=0;
			String name="";
			String names[]= {"Rice","Pulses","Wheats"};
			JSONObject firstObject=new JSONObject();
			for(int i=0;i<3;i++)
			{
				JSONArray jsonArray=new JSONArray();
				System.out.println("enter number of types of "+names[i]);
				int count=IntegerInput();
				for(int j=0;j<count;j++)
				{
					JSONObject secondObject=new JSONObject();
					System.out.println("enter the Name of "+names[i]);
					name=scanner.next();
					secondObject.put("Name",name);
					System.out.println("Enter the weight of "+names[i]);
					weight=IntegerInput();
					secondObject.put("Weight",weight);
					System.out.println("Enter the price per kg of "+names[i]);
					price=IntegerInput();
					secondObject.put("Price",price);
					secondObject.put("Total",weight*price );
					jsonArray.add(secondObject);
				}
				firstObject.put(names[i],jsonArray);
			}
			try (FileWriter file = new FileWriter("/home/bridgeit/Json/myfile.json")) {

				file.write(firstObject.toJSONString());
				file.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void getData() throws FileNotFoundException, IOException, ParseException {
			JSONParser parser = new JSONParser();
			try {
				Object object = parser.parse(new FileReader("/home/bridgeit/Json/myfile.json"));
				JSONObject jsonObject = (JSONObject) object;
				JSONArray jsonArr=(JSONArray) jsonObject.get("Rice");
				JSONObject jsonObject1= null;
				System.out.println("\n\t\t\t\t============Rice InventryData=============\n");
				 for(int i=0;i<jsonArr.size();i++)
				 {
					 jsonObject1=(JSONObject)jsonArr.get(i);
					 System.out.println("\t\t\t----------------------------------------");
					 System.out.println("\n\t\t\tName     :"+jsonObject1.get("Name"));
					 System.out.println("\t\t\t----------------------------------------");
					 System.out.println("\n\t\t\tWeight   :"+jsonObject1.get("Weight"));
					 System.out.println("\n\t\t\t----------------------------------------");
					 System.out.println("\n\t\t\tPrice    :"+jsonObject1.get("Price"));
					 System.out.println("\t\t\t----------------------------------------");
					 System.out.println("\n\t\t\tPrice    :"+jsonObject1.get("Total"));

				 }
				 JSONArray jsonArr1=(JSONArray) jsonObject.get("Pulses");
				 System.out.println("\n\t\t\t\t================Pulses InventryData=======\n");
					JSONObject jsonObject2= null;
					 for(int i=0;i<jsonArr.size();i++)
					 {
						 jsonObject2=(JSONObject)jsonArr.get(i);
						 System.out.println("\t\t\t----------------------------------------");
						 System.out.println("\n\t\t\tName    :"+jsonObject1.get("Name"));
						 System.out.println("\t\t\t----------------------------------------");
						 System.out.println("\n\t\t\tWeight  :"+jsonObject1.get("Weight"));
						 System.out.println("\t\t\t----------------------------------------");
						 System.out.println("\n\t\t\tPrice   :"+jsonObject1.get("Price"));
						 System.out.println("\t\t\t----------------------------------------");
						 System.out.println("\n\t\t\tP    :"+jsonObject1.get("Total"));

					 }
					 JSONArray jsonArr2=(JSONArray) jsonObject.get("Wheats");
				System.out.println("\n\t\t\t\t================Wheats InventryData=========\n");
						JSONObject jsonObject3= null;
						 for(int i=0;i<jsonArr.size();i++)
						 {
							 jsonObject1=(JSONObject)jsonArr.get(i);
							 System.out.println("\t\t\t----------------------------------------");
							 System.out.println("\n\t\t\tName   :"+jsonObject1.get("Name"));
							 System.out.println("\t\t\t----------------------------------------");
							 System.out.println("\n\t\t\tWeight :"+jsonObject1.get("Weight"));
							 System.out.println("\t\t\t----------------------------------------");
							 System.out.println("\n\t\t\tPrice  :"+jsonObject1.get("Price"));
							 System.out.println("\t\t\t----------------------------------------");
							 System.out.println("\n\t\t\tPrice    :"+jsonObject1.get("Total"));

						 }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}



		}
		private String userName="";
		private String userNameFullName="";
		private String userMobileNumber="";

		public void setName(String name) {

			this.userName=name;

		}
		public void setFullName(String fullName)
		{

			this.userNameFullName=fullName;
		}

		public boolean userNameCheck(String name)
		{


			if(Pattern.matches("[A-Z]{1}[a-z]{3,10}", name))
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		public boolean mobileNumberCheck(String mobileNumber)
		{
			if(Pattern.matches("[789]{1}\\d{9}", mobileNumber))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		public void setPhoneNumber(String phoneNumber) 
		{
			this.userMobileNumber=phoneNumber;
		}
		public String RegexReplace(String message)
		{
			String firstName="<<name>>";
			String fullName="<<full name>>";
			String mobileno="xxxxxxxxxx" ;
			String Date="12/03/2018";


			Pattern pattern = Pattern.compile(firstName);
			Matcher matcher = pattern.matcher(message);
			message=matcher.replaceAll(userName); 


			pattern = Pattern.compile(fullName);
			matcher = pattern.matcher(message);
			message=matcher.replaceAll(userNameFullName);


			pattern = Pattern.compile(mobileno);
			matcher = pattern.matcher(message);
			message=matcher.replaceAll(userMobileNumber);	

			Date date = new Date(0);
			String temp = date.toString();

			pattern = Pattern.compile(Date);
			matcher = pattern.matcher(message);
			message=matcher.replaceAll(temp);
			//System.out.println(message);
			return message;
		}
		public void messageDisply(String newMessage) {
			System.out.println(newMessage);

		}

		public void write(String[] stringArray) throws IOException {
			String file="/home/bridgeit/file/wordList.txt";
			StringBuilder sbf=new StringBuilder();
			if(stringArray.length > 0){
				
				sbf.append(stringArray[0]);
				for(int i=1; i < stringArray.length; i++){
					sbf.append(" ").append(stringArray[i]);
				}
				
			}
			String s=sbf.toString();
			FileWriter fileWriter=new FileWriter(file);
			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			bufferedWriter.write(s);
			bufferedWriter.flush();
			bufferedWriter.close();
		}
		@SuppressWarnings("rawtypes")
		public  void storeCalenderInQueue(int month, int year) throws InterruptedException{
			Queue q = new LinkedList();
			LinkedList<String> week;
			LinkedList<LinkedList>weekQueue=new LinkedList<LinkedList>(); 
			String[] dayOfWeek = { "S", "M", "T","W", "Th", "F", "S" };
			int[] noOfDays = { 0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			int date = 1;
			if (month == 2 || cheakLeapYear(year))
				noOfDays[2] = 29;
			int day = day(month,1, year);
			week = new LinkedList<String>();
			for (int i = 0; i < dayOfWeek.length; i++) {
				  week.add((dayOfWeek[i]));
			}
			weekQueue.add(week);
			for (int i = 1; i <7; i++) {
				week = new LinkedList();
				if (i == 1) {
					for (int k = 0; k < 7; k++) {
						if (k < day) {
							week.add(" ");
						} else {
							week.add(String.valueOf(date));
							date++;
						}
					}
				} else {
					for (int k = 0; k < 7; k++) {
						if(date<=noOfDays[month])
						week.add(String.valueOf(date));
						date++;
					}
				}
			weekQueue.add(week);
			}
			displayCalender(weekQueue,month,year);
		}
		public  void displayCalender(LinkedList<LinkedList> weekQueue,int month,int year) throws InterruptedException {
			try
			{
			Object date = " ";
			String[] monthName = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			System.out.println("              Calender of " + monthName[month] + "  " + year);
			System.out.println();
			for (int i = 0; i < 6; i++) {
				LinkedList week = weekQueue.remove();
				for (int j = 0; j < 7; j++) {
				    date =  week.remove();
				    if(date==null)
				    	break;
				    System.out.print(date+"\t");
				}
				System.out.println();
			}
		}catch(Exception e)
		{}

		}
		public void storeCalenderInStack(int month, int year) {
			@SuppressWarnings("unused")
			Stack stack=new Stack();
			Stack<String> week;
			Stack<Stack>weekQueue=new Stack<Stack>(); 
			String[] dayOfWeek = { "S", "M", "T","W", "Th", "F", "S" };
			int[] noOfDays = { 0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			int date = 1;
			if (month == 2 || cheakLeapYear(year))
				noOfDays[2] = 29;
			int day = day(month,1, year);
			week = new Stack<String>();
			for (int i = 0; i < dayOfWeek.length; i++) {
				  week.add((dayOfWeek[i]));
			}
			weekQueue.push(week);
			for (int i = 1; i <7; i++) {
				week = new Stack();
				if (i == 1) {
					for (int k = 0; k < 7; k++) {
						if (k < day) {
							week.add(" ");
						} else {
							week.add(String.valueOf(date));
							date++;
						}
					}
				} else {
					for (int k = 0; k < 7; k++) {
						if(date<=noOfDays[month])
						week.add(String.valueOf(date));
						date++;
					}
				}
			weekQueue.add(week);
			}
			displayCalender1(weekQueue,month,year);
			
		}
		private void displayCalender1(Stack<Stack> weekQueue, int month, int year) {
			
			try
			{
			Object date = " ";
			String[] monthName = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			System.out.println("              Calender of " + monthName[month] + "  " + year);
			System.out.println();
			for (int i = 0; i < 6; i++) {
				Stack week = weekQueue.lastElement();
				for (int j = 0; j < 7; j++) {
				    date =  week.lastElement();
				    if(date==null)
				    	break;
				    System.out.print(date+"\t");
				}
				System.out.println();
			}
		}catch(Exception e)
		{}
		}
		Queue cardQueue = new LinkedList();
		public String[] assignDeckOfCards() 
		{
			String[] suit = { "Club", "Diamond", "Heart", "Spade" };
				String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
				String[] deckOfCards = new String[52];
				int index = 0;
				for (int i = 0; i < suit.length; i++) {
					for (int j = 0; j < rank.length; j++) {
						deckOfCards[index++] = suit[i] + " " + rank[j];
					}
				}
				return deckOfCards;
		
		}
		public  String[] shuffle(String[] deckCards) {
			for (int i = 0; i < deckCards.length; i++) {
				int random = (int) (Math.random() * (52));
				String temp = deckCards[i];
				deckCards[i] = deckCards[random];
				deckCards[random] = temp;
			}
			return deckCards;
		}
		public  String[][] distribute(String[] deckOfShuffleCards, int noOfPlayers, int noOfCards) {
			int index = 0;
			String[][] distributedCards = new String[noOfPlayers][noOfCards];
			for (int i = 0; i < noOfPlayers; i++) {
				for (int j = 0; j < noOfCards; j++) {
					distributedCards[i][j] = deckOfShuffleCards[index++];
				}
			}
			return distributedCards;
		}
		public  void printDistibutedCards(String[][] cardsOfPlayers, int noOfPlayers, int noOfCards) {
			for (int i = 0; i < noOfPlayers; i++) {
				System.out.println("Cards of player " + (i + 1) + " are as follows :");
				for (int j = 0; j < noOfCards; j++) {
					System.out.println(cardsOfPlayers[i][j]);
				}
				System.out.println();
			}
		}
		public  void printSortedCards(String[][] playerCards, int noOfPlayers, int noOfCards) {
			String[] cards = new String[noOfCards];
			for (int i = 0; i < noOfPlayers; i++) {
				for (int j = 0; j < noOfCards; j++) {
					cards[j] = playerCards[i][j];
				}
				cardQueue.add("Cards Of Player " + (i + 1) + " are as follows..");
				sort(cards);
			}
			printSortedCardQueue();
		}
		private  void printSortedCardQueue() {
			for (int i = 0; i < 40; i++) {
				if (i % 10 == 0)
					System.out.println();
				System.out.println(cardQueue.remove());

			}
		}
		private  void sort(String[] cards) {
			char[] rank = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K' };
			for (int i = 0; i < rank.length; i++) {
				for (int j = 0; j < cards.length; j++) {
					String card = cards[j];
					char cardRank = card.charAt(card.length() - 1);
					if (cardRank == rank[i])
						cardQueue.add(card);
				}
			}
		}
		public JSONArray jsonFileReader(String filePath) {
			
			File file=new File(filePath);
			JSONArray jSonArray=null;
			try {
				FileReader fileReader=new FileReader(file);
				JSONParser jSonParser=new JSONParser();
				jSonArray=new JSONArray();
				jSonArray=(JSONArray) jSonParser.parse(fileReader);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return jSonArray;
		}
		public void jsonFileWriter1(String filePath, JSONArray jsonArray) 
		{
		
			
		}
		
		public void calenderStack(int month, int year) {

			Stack monthstack = new Stack();
			Stack day = new Stack();
			Utility utility = new Utility();

			String[] months = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			for (int i = 0; i < months.length; i++) {
				monthstack.push(months[i]);
			}
			int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if (month == 2 && cheakLeapYear(year)) {
				days[month] = 29;
			}
			for (int i = 0; i < days.length; i++) {
				day.push(days[i]);
			}
			System.out.println("   " + months[month] + " " + year);
			System.out.println(" S  M Tu  W Th  F  S");
			int d = day(month, 1, year);
			for (int i = 0; i < d; i++) {
				System.out.print("   ");
			}
			for (int i = 1; i <= days[month]; i++) {
				System.out.printf("%2d ", i);
				if (((i + d) % 7 == 0) || (i == days[month]))
					System.out.println();
			}

		}
		
		public <E> void display1() throws IOException, ParseException 
		{
			File file = new File("UserDetailes.json");
			FileReader filereader = new FileReader(file);
			JSONParser parser = new JSONParser();
			JSONArray array1 = (JSONArray) parser.parse(filereader);
			Iterator<E> itrator = array1.iterator();
			while (itrator.hasNext()) {
				JSONObject object = (JSONObject) itrator.next();
				System.out.println(object);
			}
		}
public void coupanNumberGenaration(int coupen_number) {
	LinkedHashSet<Integer> randomnumber = new LinkedHashSet<Integer>();
	int count=0;
	for (int i =0 ; i <coupen_number; i++) 
	{
		int setvalue=((getRandomNumber(10000)));
		count++;
		randomnumber.add(setvalue);
	}
	System.out.println(randomnumber + " ");
	System.out.println(count);
}
static int getRandomNumber(int max)
{
	
	Random r = new Random();
	return r.nextInt((max));
	
}

	public  int play(int cash, int target, int count) {
		double random = 0.0;
		int amount = cash;
		while (amount > 0 && amount < target) {
			random = Math.random();
			if (random > 0.5)
				amount++;
			if (random < 0.5)
				amount--;
		}
		if (amount == target)
			count++;
		return count;
	}
	
	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 *             create an account
	 */
	@SuppressWarnings("unchecked")
	public void createUserAccount() throws IOException, ParseException, Exception {
		File file = new File("/home/bridgeit/myPrograms/Javaprograms/Demo.json");
  JSONArray array=new JSONArray();
		boolean check = true;
		while (check == true) 
		{
			System.out.println("Do you want to add user 1/0");
			int choice = scanner.nextInt();
			if (choice == 1) 
			{

				FileReader filereader = new FileReader(file);
				JSONParser parser = new JSONParser();
				JSONArray array1 = (JSONArray) parser.parse(filereader);
				JSONObject json = new JSONObject();
				System.out.println("\t\t\tEnter name :");
				String name = StringInput();
				System.out.println("\t\t\tEnter balance :");
				int bal = IntegerInput();
				System.out.println("\t\t\tEnter Unique Id[Adhar] :");
				String uniqeId=StringInput();
				json.put("Name", name);
				json.put("Balance", bal);
				json.put("ShareCount", 0);
				json.put("UniqueId", uniqeId);

				array1.add(json);
				FileWriter filewriter = new FileWriter(file);
				BufferedWriter bufferedWriter=new BufferedWriter(filewriter);
				bufferedWriter.write(JSONArray.toJSONString(array1));
				bufferedWriter.flush();
				bufferedWriter.close();
				} 
			else
			{
				check = false;
			}
		}

	}

	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 *             to buy shares
	 */

	@SuppressWarnings("unchecked")
	public void buyShare() throws IOException, ParseException, Exception {
		UserDefinedStack UserDefinedStack=new UserDefinedStack();
		File file = new File("/home/bridgeit/myPrograms/Javaprograms/Demo.json");
		File file1 = new File("/home/bridgeit/myPrograms/Javaprograms/Demo1.json");
		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray stock = (JSONArray) parser.parse(filereader);
		
		FileReader filereader1 = new FileReader(file1);
		JSONParser parser1 = new JSONParser();
		JSONArray share = (JSONArray) parser1.parse(filereader1);
		System.out.println("\t\t\tEnter the userName :");
		String name = StringInput();
		System.out.println("\t\t\tEnter your uniqueId for Verification :");
		String id=StringInput();
		Iterator itr = stock.iterator();
		Iterator itr1 = share.iterator();
		boolean flag = false;
		while (itr.hasNext()) {
			JSONObject jsonobject = (JSONObject) itr.next();
			if (jsonobject.get("Name").equals(name)&&(jsonobject.get("UniqueId").equals(id))) {
				System.out.println("\t\t\tEnter the share sysmbol to buy share:[@,!,#]");
				String symbol = StringInput();
                System.out.println("\t\t\tEnter the company name corresponding to Share symbol:[TCS-!,Wifro-@,amezon-#]");
                String companyName=StringInput();
				while (itr1.hasNext())
				{
					JSONObject jsonobject1 = (JSONObject) itr1.next();
					if ((jsonobject1.get("Symbol").equals(symbol)&&jsonobject1.get("CompanyName").toString().equals(companyName)))
					{
						System.out.println("\t\t\tnumber of share you want to buy");
						int shareNumber=IntegerInput();
						System.out.println("\t\t\tPrice of each share is :"+jsonobject1.get("Price"));
						System.out.println("\t\t\tSo...Enter the ammount "+(Integer.parseInt(jsonobject1.get("Price").toString()))*shareNumber);
						int amount = IntegerInput();
						int balance = Integer.parseInt(jsonobject.get("Balance").toString());
						int price = Integer.parseInt(jsonobject1.get("Price").toString());
						int noShare = Integer.parseInt(jsonobject.get("ShareCount").toString());
						int stockShare = Integer.parseInt(jsonobject1.get("Count").toString());
						int numofshare = amount / price;
						int newbal = balance - amount;
						int sharecountcus = noShare + numofshare;
						int sharecountstock = stockShare - numofshare;
						jsonobject.remove("Balance");
						jsonobject.remove("ShareCount");
						jsonobject1.remove("Count");
						jsonobject.put("Balance", newbal);
						jsonobject.put("ShareCount", sharecountcus);
						jsonobject1.put("Count", sharecountstock);
						Date d = new Date();
						UserDefinedStack.push(d);
						String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(d);
						System.out.println("\t\t\tTransaction sucsessfull......");
						UserDefinedStack.pop();
						System.out.println("\t\t\tDate and time of transaction :" + date);
						flag = true;
						break;
					}
				}

			}
			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(stock));
			fs.flush();
			fs.close();
		}
		if (flag == false) {
			System.out.println("\t\t\tUser name not exits");
		}
		FileWriter fw = new FileWriter(file1);
		fw.write(JSONValue.toJSONString(share));
		fw.flush();
		fw.close();
	}
	
	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 *             to sale shares
	 */

	public void saleShare() throws IOException, ParseException, Exception {
		File file = new File("/home/bridgeit/myPrograms/Javaprograms/Demo.json");
		File file1 = new File("/home/bridgeit/myPrograms/Javaprograms/Demo1.json");

		
		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray stock = (JSONArray) parser.parse(filereader);
	

		FileReader filereader1 = new FileReader(file1);
		JSONParser parser1 = new JSONParser();
		JSONArray share = (JSONArray) parser1.parse(filereader1);

		System.out.println("\t\t\tEnter the userName :");
		String name = StringInput();
		System.out.println("\t\t\tEnter your uniqueId for Verification :");
		String id=StringInput();
		Iterator itr = stock.iterator();
		Iterator itr1 = share.iterator();
		boolean flag = false;
		while (itr.hasNext()) 
		{
			JSONObject jsonobject = (JSONObject) itr.next();
			if (jsonobject.get("Name").equals(name)&&(jsonobject.get("UniqueId").equals(id))) {
				System.out.println("\t\t\tEnter the share sysmbol to sale share:[@,!,#]");
				String symbol = StringInput();
				System.out.println("\t\t\tEnter the company name corresponding to Share symbol:[TCS-!,Wifro-@,amezon-#]");
                String companyName=StringInput();
				System.out.println("\t\t\tEnter the number of share to sale");
				int count = IntegerInput();
				while (itr1.hasNext()) {
					JSONObject jsonobject1 = (JSONObject) itr1.next();
					if (jsonobject1.get("Symbol").equals(symbol)) {
						int balance = Integer.parseInt(jsonobject.get("Balance").toString());
						int price = Integer.parseInt(jsonobject1.get("Price").toString());
						int noShare = Integer.parseInt(jsonobject.get("ShareCount").toString());
						int stockShare = Integer.parseInt(jsonobject1.get("Count").toString());
						int saleprize = count * price;
						int newbal = balance + saleprize;
						int sharecountcus = noShare - count;
						int sharecountstock = stockShare + count;
						jsonobject.remove("Balance");
						jsonobject.remove("ShareCount");
						jsonobject1.remove("Count");

						jsonobject.put("Balance", newbal);
						jsonobject.put("ShareCount", sharecountcus);
						jsonobject1.put("Count", sharecountstock);
						Date d = new Date();
						String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(d);
						System.out.println("\t\t\tTransaction sucsessfull......");
						System.out.println("\t\t\tDate and time of transaction :" + date);
						flag = true;
						break;
					}

				}
			}

			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(stock));
			fs.flush();
			fs.close();
		}
		if (flag == false) {
			System.out.println("User name not exits");
		}
		FileWriter fw = new FileWriter(file1);
		fw.write(JSONValue.toJSONString(share));
		fw.flush();
		fw.close();

	}
	
	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 *             display an information
	 */
	

	public <E> void display() throws IOException, ParseException, Exception {
		File file = new File("/home/bridgeit/myPrograms/Javaprograms/Demo.json");
		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray array1 = (JSONArray) parser.parse(filereader);
		Iterator<E> itrator = array1.iterator();
		System.out.println("\t*******************User-Detailes**********************");
		System.out.println("\t=======================================================");
		System.out.println("\t|=User Name|==|Balance|==|Number of Shares|==|UniqueId=|");
		System.out.println();
		while (itrator.hasNext()) {
			JSONObject object = (JSONObject) itrator.next();
			System.out.printf("%14s,%12d,%12s,%18s",object.get("Name"),object.get("Balance"),object.get("ShareCount"),object.get("UniqueId"));
			System.out.println();
		}
		System.out.println("\t=======================================================");
	}
	public void companyShareManageMent(UserDefinedLinkedList userDefinedLinkedList1, UserDefinedLinkedList userDefinedLinkedList2, UserDefinedLinkedList userDefinedLinkedList3, String companyFile) throws FileNotFoundException, IOException, ParseException  {
		JSONArray jsonArray=stockFileReading(companyFile);
		System.out.println("\t\t\t1: add company shares to list\n");
		System.out.println("\t\t\t2: Remove company shares from list\n");
		System.out.println("\t\t\t3: Disply company shares from list\n");
        int choice=IntegerInput();
        switch(choice)
        {
        case 1:
        for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject jsonObject2=(JSONObject)jsonArray.get(i);
			userDefinedLinkedList1.add(jsonObject2.get("CompanyName"));
			userDefinedLinkedList2.add(jsonObject2.get("Symbol"));
			userDefinedLinkedList3.add(jsonObject2.get("Price"));
			}
        System.out.println("Added to list sucsessfully\n");
        break;
       case 2:System.out.println("\t\t\tEnter the Company name to Remove\n");
       String name=StringInput();
    	   for(int i=0;i<jsonArray.size();i++)
		   {
				JSONObject jsonObject2=(JSONObject)jsonArray.get(i);
				if((jsonObject2.get("CompanyName").toString().equals(name)));
				Integer[] string=userDefinedLinkedList1.getElem();
			    Integer[] string2=((UserDefinedLinkedList) userDefinedLinkedList2.userDefinedLinkedList1).getElem();
				userDefinedLinkedList3.remove(jsonObject2.get("Price"));
			}
    	      
              System.out.println();
       
        case 3:diplyLinkedList(userDefinedLinkedList1,userDefinedLinkedList2,userDefinedLinkedList3,companyFile);
              break;
        }
	}
	private JSONArray stockFileReading(String companyFile) throws FileNotFoundException, IOException, ParseException 
	{
			 
			JSONParser jsonParser=new JSONParser();
			Object object=jsonParser.parse(new FileReader(companyFile));
			JSONObject jsonObject=(JSONObject)object;
			JSONArray jsonArray=(JSONArray)jsonObject.get("Stocks");
			return jsonArray;
	}
	public void diplyLinkedList(@SuppressWarnings("rawtypes") UserDefinedLinkedList userDefinedLinkedList1,UserDefinedLinkedList userDefinedLinkedList2, UserDefinedLinkedList userDefinedLinkedList3,
			String companyFile)
	{
		if(userDefinedLinkedList1.size()>0)
		{
		
			System.out.printf("\t\t\tCompany Names:%10s\n",userDefinedLinkedList1.toString());
			System.out.printf("\t\t\tCompany_Share:%10s\n",userDefinedLinkedList2.toString());
			System.out.printf("\t\t\tShare ammount:%10s\n",userDefinedLinkedList3.toString());
		}
		else
		{
			System.out.println("\t\t\tNo data to disply\n");
		}
		
	}
	public String[] mergeSortFileReading() throws IOException
	{
		String mergeSortFile="/home/bridgeit/file/MergeSortStore.txt";
		FileReader fileReader=new FileReader(mergeSortFile);
		String lines = null;
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		if(bufferedReader.readLine()!=null)
		{
		
			lines = bufferedReader.readLine();

		}
		String array[]=lines.split(" ");
		return array;
	}
	public void removeDataFromLinkedList(UserDefinedLinkedList userDefinedLinkedList1,
			UserDefinedLinkedList userDefinedLinkedList2, UserDefinedLinkedList userDefinedLinkedList3,
			String companyFile) {
		System.out.println(userDefinedLinkedList1.pop()+"Removed From list");
		
	}
}



