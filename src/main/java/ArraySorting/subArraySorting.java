package ArraySorting;

import java.util.Arrays;

public class subArraySorting {
	
	public static void main(String[] args) {
		int[] arr= {3,6,1,10,34,12,17,22};
		Arrays.sort(arr,1,6);
		System.out.println("modified sorting arr[] "+Arrays.toString(arr));
	}

}
