/*************************************************************************************************************
 * Purpose: Singleton design Pattern-Eager Initialization
 *        
 * @author bridgeit
 * 
 * Date: 24/03/18
 * 
 **************************************************************************************************************/
package com.bridgeit.designPattern.SingletonPattern;

public class EagerInitialization {
	    
	    private static final EagerInitialization instance = new EagerInitialization();
	    
	   
	    private EagerInitialization(){}

	    public static EagerInitialization getInstance(){
	        return instance;
	    }
	}

