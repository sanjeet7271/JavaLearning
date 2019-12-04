package com.JavaMCQ;
/**
 * 
 * static local variables are not allowed in Java
 *
 */
class Test { 
	   public static void main(String args[]) { 
	       System.out.println(fun()); 
	   } 
	   static int fun() { 
	       static int x= 0; 
	       return ++x; 
	   } 
	} 