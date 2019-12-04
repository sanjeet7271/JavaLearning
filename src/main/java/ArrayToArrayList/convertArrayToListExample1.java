package ArrayToArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class convertArrayToListExample1 {
	public static void main(String[] args) {
		String[] str= {"sanjeet","Rajan","Vishal","Arif"};
		List<String> list=new ArrayList<String>(Arrays.asList(str));
		list.add("Akash");
		list.add("Mithun");
		
		System.out.println(list);
		for(String str1:list) {
			System.out.println(str1);
		}
	}

}
