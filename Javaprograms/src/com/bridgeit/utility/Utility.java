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
		for(int i=1;i<=Number;i++)
		{
			if(((i)&(i-1))==0)
				System.out.println(i);
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

		if (low == high) {
			if (array[low] == key)
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
		@SuppressWarnings("resource")
		public String[] fileReading() throws IOException {
			String file="/home/bridgeit/file/wordList.txt";
			BufferedReader bufferedReader = null;
			bufferedReader = new BufferedReader(new FileReader(file));

			String lines = null;
			lines = bufferedReader.readLine();

			System.out.println("------>" + lines);

			String[] stringArray = lines.split(" ");
			return stringArray;
		}
		@SuppressWarnings("rawtypes")
		public void filewriting(UserDefinedLinkedList ll) throws IOException {
			new File("/home/bridgeit/file/wordList.txt");
			ll.toString();
			/*BufferedWriter BufferedWriter = new BufferedWriter(new FileWriter(files));
			BufferedWriter.write(string);
			BufferedWriter.flush();*/
			FileWriter fileWriter = new FileWriter("/home/bridgeit/file/wordList.txt");
			  PrintWriter printWriter = new PrintWriter(fileWriter);
			  printWriter.flush();
			  fileWriter.close();
			 
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
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void hasingImplimentation(String[] arrray) throws FileNotFoundException
		{
			@SuppressWarnings("rawtypes")
			HashMap<Integer, UserDefinedLinkedList>hm=new HashMap<Integer, UserDefinedLinkedList>();
			int hash=-1;
			int newArray[]=new int[arrray.length];
			for(int i=0;i<arrray.length;i++)
			{
				newArray[i]=Integer.parseInt(arrray[i]);
			}
			for(int i=0;i<newArray.length;i++)
			{
				hash=newArray[i]%11;
				if(hm.containsKey(hash))
				{
					UserDefinedLinkedList ll=hm.get(hash);
					ll.add(newArray[i]);
				}
				else
				{
					hm.put(hash, new UserDefinedLinkedList());
					UserDefinedLinkedList ll=hm.get(hash);
					ll.add(newArray[i]);
				}
			}
			System.out.println("enter the key");
			int key=scan.nextInt();
			hash=key%11;
			if(hm.containsKey(hash))
			{
				UserDefinedLinkedList ll=hm.get(hash);
				if(ll.search(key))
				{
					ll.remove(key);
					System.out.println(key+" found and removed from the list");
					writeUsingFileWriter(ll.toString());
				}
				else
				{
					ll.add(key);
					System.out.println(key+" Not found and added to the list");
					writeUsingFileWriter(ll.toString());

				}
			}
			else
			{
				hm.put(hash, new UserDefinedLinkedList());
				hm.get(hash);


			}
			Set<Integer> keys = hm.keySet(); 
			for(Integer key1: keys)
			{ 
				UserDefinedLinkedList value = hm.get(key1);
				System.out.print(key1+"-");
				value.disply();
				System.out.println();
			}
		}
		public void writeUsingFileWriter(String data) {
			File file = new File("/home/bridgeit/file/wordList.txt");
			FileWriter fr = null;
			try {
				fr = new FileWriter(file);
				fr.write(data);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{

				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
					 System.out.println("----------------------------------------");
					 System.out.println("\n\t\t\tName     "+jsonObject1.get("Name"));
					 System.out.println("----------------------------------------");
					 System.out.println("\n\t\t\tWeight   "+jsonObject1.get("Weight"));
					 System.out.println("\n\t\t\t----------------------------------------");
					 System.out.println("\n\t\t\tPrice    "+jsonObject1.get("Price"));
					 System.out.println("----------------------------------------");

				 }
				 JSONArray jsonArr1=(JSONArray) jsonObject.get("Pulses");
				 System.out.println("\n\t\t\t\t================Pulses InventryData=======\n");
					JSONObject jsonObject2= null;
					 for(int i=0;i<jsonArr.size();i++)
					 {
						 jsonObject1=(JSONObject)jsonArr.get(i);
						 System.out.println("----------------------------------------");
						 System.out.println("\n\t\t\tName    "+jsonObject1.get("Name"));
						 System.out.println("----------------------------------------");
						 System.out.println("\n\t\t\tWeight  "+jsonObject1.get("Weight"));
						 System.out.println("----------------------------------------");
						 System.out.println("\n\t\t\tPrice   "+jsonObject1.get("Price"));
						 System.out.println("----------------------------------------");

					 }
					 JSONArray jsonArr2=(JSONArray) jsonObject.get("Wheats");
				System.out.println("\n\t\t\t\t================Wheats InventryData=========\n");
						JSONObject jsonObject3= null;
						 for(int i=0;i<jsonArr.size();i++)
						 {
							 jsonObject1=(JSONObject)jsonArr.get(i);
							 System.out.println("----------------------------------------");
							 System.out.println("\n\t\t\tName   "+jsonObject1.get("Name"));
							 System.out.println("----------------------------------------");
							 System.out.println("\n\t\t\tWeight "+jsonObject1.get("Weight"));
							 System.out.println("----------------------------------------");
							 System.out.println("\n\t\t\tPrice  "+jsonObject1.get("Price"));
							 System.out.println("----------------------------------------");

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
		@SuppressWarnings({ "unchecked", "unused", "null" })
		public void createUser(String file) throws IOException, ParseException
		{
			if((file.exists() && file.length()> 0))
			{
				JSONParser jsonParser=new JSONParser();
				JSONObject object=(JSONObject)jsonParser.parse(fr);
				JSONObject jsonObject2=(JSONObject)object;
				String name1=(String) jsonObject2.get("User_name");

				if(name1.equalsIgnoreCase(name))
				{
					System.out.println("User name "+name+"Already exsists");
				}

			}
			/*FileWriter fileWriter = new FileWriter("/home/bridgeit/Json/userDetailes.json");

				fileWriter.write(((JSONObject) jsonObject).toJSONString());
				System.out.println(jsonObject.toJSONString());
				fileWriter.flush();
				fileWriter.close();*/
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jsonObject.toJSONString());
			bw.close();
		}
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		public void buying() throws IOException, ParseException
		{
			File file1=new File("/home/bridgeit/Json/userDetailes.json");
			File file2=new File();
			if(file1.exists()&&file2.exists())
			{
				@SuppressWarnings("resource")
				FileReader fr1=new FileReader(file1);
				JSONParser parser = new JSONParser();
				JSONArray user = (JSONArray) parser.parse(fr1);


				@SuppressWarnings("resource")
				FileReader fr2=new FileReader(file2);
				new JSONParser();
				JSONArray stockSymbol = (JSONArray) parser.parse(fr2);


				Iterator<?> itr = ((List<Integer>) user).iterator();
				Iterator<?> itr1 = ((List<Integer>) stockSymbol).iterator();
				System.out.println("\t\tEnter the user name");
				String name=StringInput();
				boolean flag=false;
				while(itr.hasNext())
				{
					JSONObject obj=(JSONObject)itr.next();
					if(obj.get("user_name").equals(name))
					{
						System.out.println("Enter the stock Symbol: @#!");
						StringInput();
					}
					while(itr1.hasNext())
					{
						JSONObject obj2=(JSONObject)itr.next();
						if(obj.get("stock_Symbol").equals(stockSymbol))
						{
							
							flag = true;
							break;
						}

					}

				}
				if(flag==false)
				{
					System.out.println("User name not found");
				}
				else
				{
					HashMap<String, LocalDateTime>hashMap=new HashMap<String, LocalDateTime>();
					UserDefinedDeQueue userQueue=new UserDefinedDeQueue();

					double currentTime=System.currentTimeMillis();
					userQueue.add(currentTime);
					UserDefinedStack userDefinedStack=new UserDefinedStack();
					DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime now = LocalDateTime.now();  
					userDefinedStack.push(now);
					hashMap.put(name, now);
					JSONObject json = new JSONObject();
					json.putAll( hashMap );
					File file=new File("/home/bridgeit/Json/userDetailes.json");
					FileWriter fr=new FileWriter(file);
					fr.write(json.toJSONString());
				}
			}

		}
		@SuppressWarnings({ "unchecked", "unused" })
		public void selling() throws Exception
		{
			File file1=new File("/home/bridgeit/Json/userDetailes.json");
			File file2=new File("/home/bridgeit/Json/stockSymbols.json");
			if(file1.exists()&&file2.exists())
			{
				@SuppressWarnings("resource")
				FileReader fr1=new FileReader(file1);
				JSONParser parser = new JSONParser();
				JSONArray user = (JSONArray) parser.parse(fr1);


				@SuppressWarnings("resource")
				FileReader fr2=new FileReader(file2);
				new JSONParser();
				JSONArray stockSymbol = (JSONArray) parser.parse(fr2);


				Iterator<?> itr = ((List<Integer>) user).iterator();
				Iterator<?> itr1 = ((List<Integer>) stockSymbol).iterator();
				System.out.println("\t\tEnter the user name");
				String name=StringInput();
				boolean flag=false;
				while(itr.hasNext())
				{
					JSONObject obj=(JSONObject)itr.next();
					if(obj.get("user_name").equals(name))
					{
						System.out.println("Enter the stock Symbol: @#!");
						StringInput();
					}
					while(itr1.hasNext())
					{
						JSONObject obj2=(JSONObject)itr.next();
						if(obj.get("stock_Symbol").equals(stockSymbol))
						{
							System.out.println("Enter the amount");
							int ammount = IntegerInput();

							int balence = Integer.parseInt(obj.get("amount").toString());
							int price = Integer.parseInt(obj2.get("amount").toString());
							int numberOfSharesOfbuyer = Integer.parseInt(obj.get("number_Share").toString());
							int stockShare = Integer.parseInt(obj2.get("Count").toString());

							int numofshare = ammount / price;
							int newbal = balence + ammount;
							int sharecountcus = numberOfSharesOfbuyer - numofshare;
							int newNumberOfShares = stockShare + numofshare;

							obj.remove("amount");
							obj.remove("number_Share");
							obj2.remove("Count");
							obj.put("amount", newbal);
							obj.put("number_Share", sharecountcus);
							obj2.put("Count", newNumberOfShares);

							flag = true;
							break;
						}

					}

				}
				if(flag==false)
				{
					System.out.println("User name not found");
				}
				else
				{
					HashMap<String, LocalDateTime>hashMap=new HashMap<String, LocalDateTime>();
					@SuppressWarnings("rawtypes")
					UserDefinedDeQueue userQueue=new UserDefinedDeQueue();

					double currentTime=System.currentTimeMillis();
					userQueue.add(currentTime);
					UserDefinedStack userDefinedStack=new UserDefinedStack();
					DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime now = LocalDateTime.now();  
					userDefinedStack.push(now);
					hashMap.put(name, now);
					JSONObject json = new JSONObject();
					json.putAll( hashMap );
					File file=new File("userDetailes.json");
					FileWriter fr=new FileWriter(file);
					fr.write(json.toJSONString());
				}
			}

		}
		public void display() throws FileNotFoundException, IOException, ParseException {
			new FileReader("/home/bridgeit/Json/userDetailes.json");

			FileInputStream fileInputStream = null;
			StringBuffer stringBuffer = new StringBuffer("");
			try{
				fileInputStream=new FileInputStream("/home/bridgeit/Json/userDetailes.json");
				int i;
				while((i=fileInputStream.read())!=-1)
				{
					stringBuffer.append((char)i);
				}
				System.out.println(stringBuffer.toString());
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally{
				if(fileInputStream!=null){  
					fileInputStream.close();
				}
			}

		}
		public void adduser()
		{

		}
		/*File file1=new File("/home/bridgeit/Json/AddressBook.json");


		public JSONArray jsonarray=new JSONArray();
		@SuppressWarnings({ "unused", "unchecked" })
		public void addPerson() throws IOException, ParseException
		{
			FileReader fr=new FileReader(file1);
			if(file1.length()>0)
			{
				JSONObject object=(JSONObject)new JSONParser().parse(fr);
				JSONObject jsonObject2=(JSONObject)object;
				jsonarray=(JSONArray) jsonObject2.get("user");
			}
			else
			{
				JSONObject jsonObject=new JSONObject();
				System.out.println("Enter First Name: ");
				jsonObject.put("First_name", StringInput());
				System.out.println("Enter Last Name: ");
				jsonObject.put("Last_name", StringInput());
				@SuppressWarnings("rawtypes")
				Map map=new LinkedHashMap(3);
				System.out.println("Enter the city: ");
				map.put("City", StringInput());
				System.out.println("Enter the Zip code: ");
				map.put("ZIP", IntegerInput());
				jsonObject.put("address", map);
				jsonarray.add(jsonObject);

				jsonObject.put("user", jsonarray);
			}
			System.out.println(jsonarray);
		}
		public void editPerson()
		{


		}
		public void deletePerson() {


		}
		public void sortPerson() {


		}
		public void sortUser() {


		}*
		public Date stringToDate(String stringInput) throws java.text.ParseException {
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(stringInput);  
			return date1;
		}
		JSONObject jsonObject=new JSONObject();
		/*public void savingInfile(ArrayList<DoctersModel> doctorList) 
		{
			JSONArray jsonArray=new JSONArray(doctorList);
			
		}*/
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
		

}

