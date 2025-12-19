package Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapImpl {
	void main() {
		
		//Map<Key, Value> 
		//One key can be null, multiple values can be null
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "Charan");
		map.put(102, "Bharath");
		map.put(101, "Karan");
		map.put(108, "Senthil");
		map.put(203, "Roshan");
		map.put(506, "Darma");
		map.put(709, "Nathan");
		map.put(804, "Sree");
		map.put(903, "Jai");
		map.put(null, null);
		map.put(null, "Charan");
		map.put(110, null);
		
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