package Collections;

import java.util.List;
import java.util.ArrayList;

class Arraylist {
	void main() {
		// List Takes the insertion maintained Order when ever it operates, Duplication Allowed, No Hashing for insertion
		List<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);
		
		IO.println(ls);
		
		ls.addFirst(5);
		ls.addLast(0);
		ls.add(2);
		
		IO.println(ls);

		ls.add(3, 7);
		IO.println(ls);

		IO.println(ls.indexOf(2));
		IO.println(ls.lastIndexOf(2));
		
		IO.println(ls.reversed());
		IO.println(ls);
		
		ls.remove(2);
		IO.println(ls);

		ls.removeFirst();
		IO.println(ls);
		
		ls.removeLast();
		IO.println(ls);
		
		ls.clear();
		IO.println(ls);
	}
}
