package HashMapCollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Example3 {

	public static void main(String[] args) {

		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("Sanjeet", 24);
		map.put("Rajan", 23);
		map.put("Vishal", 26);
		map.put("Ayush", 7);
		map.put("Ajay", 9);
		
		Set<Map.Entry<String, Integer>> set=map.entrySet();
		Iterator<Map.Entry<String, Integer>> itr=set.iterator();
		while(itr.hasNext()) {
			Map.Entry<String, Integer> mEntry=itr.next();
			System.out.println(mEntry.getKey()+ "  "+mEntry.getValue());
		}

	}

}
