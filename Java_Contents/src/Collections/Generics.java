package Collections;

import java.util.ArrayList;

public class Generics {
	void main() {
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(10);
		l1.addFirst(9);
		l1.addLast(11);
		IO.println(l1);
		
		
		for (int i: l1) {
			IO.println(i);
		}
	}
}