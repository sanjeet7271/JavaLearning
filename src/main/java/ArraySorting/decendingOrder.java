package ArraySorting;

import java.util.Arrays;
import java.util.Collections;

public class decendingOrder {
	public static void main(String[] args) {
		Integer[] arr= {7,5,3,10,12,4,18};
		 Arrays.sort(arr, Collections.reverseOrder()); 
		  
	        System.out.printf("Modified arr[] : %s", 
	                          Arrays.toString(arr));
	}

}
