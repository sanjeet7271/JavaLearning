package ListToArray;

import java.util.ArrayList;
import java.util.List;

public class ListToArrayExample1 {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		list.add(10);
		list.add(7);
		list.add(6);
		
		Integer[] num=new Integer[list.size()];
		num=list.toArray(num);
		
		for(int num1:num) {
			System.out.println(num1);
		}
	}
	
}
