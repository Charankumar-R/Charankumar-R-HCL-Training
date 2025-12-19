package Collections;

import java.util.ArrayList;
import java.util.List;

public class Nongenerics {

	public static void main(String[] args) {
		ArrayList li = new ArrayList<>();
		
		li.add(100);
		li.add("Charan");
		li.add(10.1);
		li.add(false);
		
		IO.println(li);
		String str = (String) li.get(1);
		IO.println(li);
	}
}