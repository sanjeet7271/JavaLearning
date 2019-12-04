package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetColletion {

	public static void main(String[] args) {
		
		Set<Integer> has=new HashSet<Integer>();
		has.add(4);
		has.add(14);
		has.add(42);
		has.add(25);
		has.add(67);
		has.add(70);
		System.out.print(has+" ");
		has.forEach(hasA -> {
			System.out.println(hasA);
		});
		
		Iterator<Integer> itr=has.iterator();
		while(itr.hasNext()) {
			int num=itr.next();
			System.out.println(num);
		}
	}

}
