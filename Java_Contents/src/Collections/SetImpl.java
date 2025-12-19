package Collections;

import java.util.HashSet;
import java.util.Set;

class SetImpl {
	void main() {
		
		// Set Takes random Order when ever it operates, No Duplication, Hashing used for insertion
		Set<Double> set = new HashSet<>();
		
		set.add(10.1);
		set.add(20.2);
		set.add(30.3);
		set.add(10.1);
		
		IO.println(set);
		
		set.add(10.2);
		IO.println(set);
		
		set.add(10.3);
		IO.println(set);
		
		IO.println(set.contains(10.5));
		
		
	}
}