package HashMapCollection;

import java.util.HashMap;
import java.util.Map;

public class Example2 {

	public static void main(String[] args) {
		
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(12, "A");
		map.put(23, "BA");
		map.put(2, "AC");
		map.put(22, "AB");
		map.put(122, "ABC");
		
		map.forEach((no,Name)->{
			System.out.println(no+ " : "+Name);
		});
		

	}

}
