package HashMapCollection;

import java.util.HashMap;
import java.util.Map;

public class NoOfCharacter {
	public static void NoOfChar(String str) {
		
		char ch[]=str.toCharArray();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(char c:ch) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		for(Map.Entry mEntry:map.entrySet()) {
			System.out.println(mEntry.getKey()+" : "+mEntry.getValue());
		}
	}

	public static void main(String[] args) {
		
		String str="Hello World";
		NoOfChar(str);
	}

}
