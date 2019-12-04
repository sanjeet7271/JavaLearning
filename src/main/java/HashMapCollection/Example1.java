package HashMapCollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Example1 {

	public static void main(String[] args) {
		
		Map<Integer,String> map=new HashMap<Integer, String>();
		map.put(2, "Sanjeet");
		map.put(4, "Arav");
		map.put(5, "Rajan");
		Set entry=map.entrySet();
		Iterator itr=entry.iterator();
		while(itr.hasNext() ) {
			 Map.Entry mentry = (Map.Entry)itr.next();
			System.out.println(mentry.getKey()+ "  "+mentry.getValue());
		} 	 	
		System.out.println(map.get(2));
	}

}
