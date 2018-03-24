package com.bridgeit.designPattern.FacadeDesignPattern;

public class SortinApp 
{
public static void main(String[] args)
{
       SortingManager  sortingManager=new  SortingManager();
       System.out.println("========================");
       System.out.print("Insertion sort for Integer\n");
	   sortingManager.insertionSortForIntegerFromSortinManager();
	   System.out.println("========================");
       System.out.print("Insertion sort for String\n");
	   sortingManager.insertionSortStringFromSortinManager();
	   System.out.println("========================");
       System.out.print("bubble sort for Integer\n");
	   sortingManager.bubbleSortForIntegerFromSortinManager();
	   System.out.println("========================");
       System.out.print("bubble sort for Integer\n");
	   sortingManager.bubbleSortForStringFromSortinManager();
	   System.out.println("========================");
}
}
