package com.JavaMCQ;
/**
 * 
 * If we are not declare constructor, Default constructor will be called
 *
 */
class Test1 { 
	   private static int x; 
	   public static void main(String args[]) { 
	       System.out.println(fun()); 
	   } 
	   static int fun() { 
	       return ++x; 
	   } 
	} 
