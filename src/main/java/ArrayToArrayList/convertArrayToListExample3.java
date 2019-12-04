package ArrayToArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class convertArrayToListExample3 {
	public static void main(String[] args) {
		String[] str= {"sanjeet","Rajan","Vishal","Arif","Akash","Mithun"};
		List<String> list=new ArrayList<String>();
		for(int i=0;i<str.length;i++) {
			list.add(str[i]);
		}
		
		System.out.println(list);
		for(String str1:list) {
			System.out.println(str1);
		}
	}

}
