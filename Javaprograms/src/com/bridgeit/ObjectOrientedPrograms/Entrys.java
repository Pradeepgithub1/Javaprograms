package com.bridgeit.ObjectOrientedPrograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.jar.JarException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.utility.Utility;

public class Entrys 
{
	Utility utility=new Utility();
	String file="/home/bridgeit/Json/BookEntry.json";
	JSONObject jsonObject=new JSONObject();
	JSONArray jsonArray=new JSONArray();
	public void addingToJsonFile(String first, String last, String address, int zip, String city, String mobilenumber) throws IOException, ParseException
	{
		FileReader fileReader=new FileReader(file);
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		if(bufferedReader.readLine()==null)
		{
			addingToObject(jsonArray,first,last,address,zip,city,mobilenumber);
		}
		else
		{
			JSONArray jsonArray=getCurrentObject();
			addingToObject(jsonArray,first,last,address,zip,city,mobilenumber);
		}
		writingIntoFile(jsonObject);
		
	}
	private void writingIntoFile(JSONObject jsonObject) throws IOException {
		FileWriter fileWriter=new FileWriter(file);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		bufferedWriter.write(jsonObject.toJSONString());
		bufferedWriter.flush();
		bufferedWriter.close();
		
	}
	private JSONArray getCurrentObject() throws FileNotFoundException, IOException, ParseException
	{
		 JSONArray jsonArray=jsonPraser();
		
		return jsonArray;
	}
	private JSONArray jsonPraser() throws FileNotFoundException, IOException, ParseException 
	{
		JSONParser jsonParser=new JSONParser();
		Object obj=jsonParser.parse(new FileReader(file));
		JSONObject jsonObject=(JSONObject)obj;
		JSONArray jsonArray=(JSONArray) jsonObject.get("Book");
		
		return jsonArray;
	}
	private void addingToObject(JSONArray jsonArray2, String first, String last, String address, int zip, String city, String mobilenumber)
	{
		JSONObject jsonObject1=new JSONObject();
		jsonObject1.put("FirstNmae", first);
		jsonObject1.put("LastName", last);
		jsonObject1.put("Adress", address);
		jsonObject1.put("Zip-Code", zip);
		jsonObject1.put("city", city);
		jsonObject1.put("MobileNumber", mobilenumber);
		jsonArray.add(jsonObject1);
		jsonObject.put("Book", jsonArray);
	}
	public void removeAnEntry(String stringInput, String string) throws FileNotFoundException, IOException, ParseException
	{
		JSONArray jsonArray=jsonPraser();
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject jsonObject1=(JSONObject)jsonArray.get(i);
			if(jsonObject1.get("FirstNmae").equals(stringInput)&&(jsonObject1.get("LastName").equals(string)))
			{
				jsonArray.remove(jsonObject1);
				break;
			}
		}
		jsonObject.put("Book", jsonArray);
		writingIntoFile(jsonObject);
	}
	@SuppressWarnings("unchecked")
	public void editEntry1(String first1) throws FileNotFoundException, IOException, ParseException {
		JSONArray jsonArray=jsonPraser();
		boolean flag=true;
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject jsonObject1=(JSONObject)jsonArray.get(i);
			if(jsonObject1.get("FirstNmae").equals(first1))
			{
				System.out.println("\t\t\tEnter the new name to update\n");
				String name=utility.StringInput();
				jsonObject1.put("FirstNmae", name);
				System.out.println("updated sucsessfully....");
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println("\t\t\tEnterd name not found in the list");
		jsonObject.put("Book", jsonArray);
		writingIntoFile(jsonObject);
	}
	public void editEntry2(String last1) throws FileNotFoundException, IOException, ParseException {
		
		JSONArray jsonArray=jsonPraser();
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject jsonObject1=(JSONObject)jsonArray.get(i);
			if(jsonObject1.get("LastName").equals(last1))
			{
				System.out.println("\t\t\tEnter the new last name to update\n");
				String name=utility.StringInput();
				jsonObject1.put("LastName", name);
				System.out.println("updated sucsessfully....");
				break;
			}
		}
		jsonObject.put("Book", jsonArray);
		writingIntoFile(jsonObject);
	}
	public void editEntry3(String address1) throws FileNotFoundException, IOException, ParseException {
		

		JSONArray jsonArray=jsonPraser();
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject jsonObject1=(JSONObject)jsonArray.get(i);
			if(jsonObject1.get("Adress").equals(address1))
			{
				System.out.println("\t\t\tEnter the new address to update\n");
				String name=utility.StringInput();
				jsonObject1.put("Adress", name);
				System.out.println("updated sucsessfully....");
				break;
			}
		}
		jsonObject.put("Book", jsonArray);
		writingIntoFile(jsonObject);
	}
	public void editEntry4(int zip) throws IOException, ParseException {

		JSONArray jsonArray=jsonPraser();
		
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject jsonObject1=(JSONObject)jsonArray.get(i);
			if(Integer.parseInt(jsonObject1.get("Zip-Code").toString())==(zip))
			{
				System.out.println("\t\t\tEnter the new Zip-code to update\n");
				int name=utility.IntegerInput();
				jsonObject1.put("Zip-Code", name);
				System.out.println("updated sucsessfully....");
				break;
			}
		}
		jsonObject.put("Book", jsonArray);
		writingIntoFile(jsonObject);
	}
	public void sorting(int whichEntry1) throws FileNotFoundException, IOException, ParseException
	{
		switch (whichEntry1) 
		{
		case 1:
			   JSONArray jsonArray=jsonPraser();
               System.out.println("\t\t\tBefore sorting... ");			  
			    disply(jsonArray);
			   jsonArray=jsonPraser();
			   String keyname="FirstNmae";
			   sortByname(jsonArray,keyname);
			   JSONArray jsonArray1=jsonPraser();
			   System.out.println("\t\t\tAfter sorting... ");	
			   disply(jsonArray1);
			   System.out.println("\t\t\tSorted by name Sucsessfully...");
			
			break;
		case 2:JSONArray jsonArray01=jsonPraser();
            System.out.println("\t\t\tBefore sorting... \n");			  
		    disply(jsonArray01);
		   jsonArray=jsonPraser();
		   String keyname1="Zip-Code";
		   sortByZip(jsonArray,keyname1);
		   JSONArray jsonArray2=jsonPraser();
		   System.out.println("\t\t\tAfter sorting... \n");	
		   disply(jsonArray2);
		   System.out.println("\t\t\tSorted by Zip-code Sucsessfully...\n");
		

		default:
			break;
		}
		
	}
	private void disply(JSONArray jsonArray) 
	{
		for(int i=0;i<jsonArray.size();i++)
		{
			System.out.println("\t\t\t============Entry"+" "+(i+1)+"============\n");
			JSONObject jsonObject1=(JSONObject)jsonArray.get(i);
			System.out.println("\t\t\tFirst Name      :"+jsonObject1.get("FirstNmae"));
		
			System.out.println("\t\t\tLast Name       :"+jsonObject1.get("LastName"));
			
			System.out.println("\t\t\tAddress         :"+jsonObject1.get("Adress"));
			System.out.println("\t\t\tCity            :"+jsonObject1.get("city"));
			System.out.println("\t\t\tMobile number   :"+jsonObject1.get("MobileNumber"));

			System.out.println("\t\t\tZip-code        :"+jsonObject1.get("Zip-Code"));
			System.out.println("\n");


		}
		
	}
	private void sortByname(JSONArray jsonArray,String keyname) throws IOException {
	    JSONArray sortedJsonArray = new JSONArray();

	    ArrayList<JSONObject> jsonValues = new ArrayList<JSONObject>();
	    for (int i = 0; i < jsonArray.size(); i++) {
	        jsonValues.add((JSONObject)jsonArray.get(i));
	    }
	    Collections.sort( jsonValues, new Comparator<JSONObject>()
	    {
	        private  final  static String KEY_NAME = "FirstNmae";

	        @Override
	        public int compare(JSONObject a, JSONObject b) 
	        {
	            String valA = new String();
	            String valB = new String();

	            try
	            {
	                valA = (String) a.get(KEY_NAME);
	                valB = (String) b.get(KEY_NAME);
	            } 
	            catch (Exception e) 
	            {
	                
	            }

	            return valA.compareTo(valB);

	        }
	    });

	    for (int i = 0; i < jsonArray.size(); i++) {
	        sortedJsonArray.add(jsonValues.get(i));
	    }
			jsonObject.put("Book", sortedJsonArray);
			writingIntoFile(jsonObject);
		System.out.println("\n\n\n");
		
	}
	
	private void sortByZip(JSONArray jsonArray,String keyname) throws IOException {
	    JSONArray sortedJsonArray = new JSONArray();

	    ArrayList<JSONObject> jsonValues = new ArrayList<JSONObject>();
	    for (int i = 0; i < jsonArray.size(); i++) {
	        jsonValues.add((JSONObject)jsonArray.get(i));
	    }
	    Collections.sort( jsonValues, new Comparator<JSONObject>()
	    {
	        private  final  static String KEY_NAME = "Zip-Code";

	        @Override
	        public int compare(JSONObject a, JSONObject b) 
	        {
	            String valA = new String();
	            String valB = new String();

	            try
	            {
	                valA =  a.get(KEY_NAME).toString();
	                valB = b.get(KEY_NAME).toString();
	            } 
	            catch (Exception e) 
	            {
	                
	            }

	            return valA.compareTo(valB);

	        }
	    });

	    for (int i = 0; i < jsonArray.size(); i++) {
	        sortedJsonArray.add(jsonValues.get(i));
	    }
			jsonObject.put("Book", sortedJsonArray);
			writingIntoFile(jsonObject);
		System.out.println("\n\n\n");
		
	}
	

}
