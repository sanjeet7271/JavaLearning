package ArrayToArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class convertArrayToListExample2 {
	public static void main(String[] args) {
		String[] str= {"sanjeet","Rajan","Vishal","Arif"};
		List<String> list=new ArrayList<String>();
		Collections.addAll(list,str);
		list.add("Akash");
		list.add("Mithun");
		
		System.out.println(list);
		for(String str1:list) {
			System.out.println(str1);
		}
	}

}
