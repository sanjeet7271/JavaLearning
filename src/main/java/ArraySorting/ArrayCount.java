package ArraySorting;

import java.util.Arrays;

public class ArrayCount {
	public static void main(String[] args) {
		int arr[] = { 4,3,2,1,5,6 };
		countLeastNumber(arr);
	}

	private static void countLeastNumber(int[] arr) {
		//int count = 0;
		System.out.println(Arrays.toString(arr));
		int arr1[]=new int[arr.length];
		int n=arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (arr[i] > arr[j]) {
					arr1[i]++;
				}
			}

		}
		System.out.println(Arrays.toString(arr1));

	}

}
