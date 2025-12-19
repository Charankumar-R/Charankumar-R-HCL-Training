package Collections;

import java.util.*;
import java.util.Set;

class TreeSetImpl {
	void main() {
		
		// TreeSet Takes Sorting Order when ever it operates, No Duplication
		Set<Integer> set = new TreeSet<>();
		
		set.add(10);
		set.add(30);
		set.add(20);
		set.add(10);
		
		IO.println(set);
		
		for (int i: set) {
			IO.print(i+" ");
		}
		IO.println();
		
		set.add(40);
		for (int i: set) {
			IO.print(i+" ");
		}
		IO.println();
		
		set.add(10);
		for (int i: set) {
			IO.print(i+" ");
		}
		IO.println();
		
		IO.println(set.contains(10));
	}
}