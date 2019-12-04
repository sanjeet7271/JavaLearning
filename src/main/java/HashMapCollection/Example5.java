package HashMapCollection;

import java.util.HashMap;
import java.util.Map;

public class Example5 {

	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("Sanjeet", 24);
		map.put("Rajan", 23);
		map.put("Vishal", 26);
		map.put("Ayush", 7);
		map.put("Ajay", 9);
		
		for(Map.Entry<String, Integer> mEntry: map.entrySet()) {
			System.out.println(mEntry.getKey()+ " "+ mEntry.getValue());
		}

	}

}
