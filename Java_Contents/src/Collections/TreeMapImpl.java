package Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapImpl {
	void main() {
		Map<Integer, String> map = new TreeMap<>();
		map.put(100, "Charan");
		map.put(102, "Bharath");
		map.put(601, "Karan");
		map.put(108, "Senthil");
		map.put(903, "Roshan");
		map.put(106, "Darma");
		map.put(809, "Nathan");
		map.put(104, "Sree");
		map.put(703, "Jai");
		
		IO.println(map.get(102));
		
		IO.println(map.getOrDefault(105, "None"));
		
		IO.println(map.containsKey(104));
		IO.println(map.containsValue("Charan"));
		IO.println(map);

		IO.println(map.remove(104));
		
		IO.println(map.replace(103, "Kailash"));
		
		IO.println(map.keySet());
		IO.println(map.values());
		
		for(Map.Entry<Integer, String> m1 : map.entrySet()) {
			IO.println("Key: "+ m1.getKey() + "\tValue: "+ m1.getValue());
		}
	}
}