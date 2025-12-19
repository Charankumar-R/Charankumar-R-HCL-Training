package Collections;

import java.util.Hashtable;
import java.util.Map;

public class HashTableImpl {
	void main() {
		
		//Hashtable<Key, Value> 
		//No key can be null, No values can be null
		Map<Integer, String> map = new Hashtable<>();
		map.put(100, "Charan");
		map.put(102, "Bharath");
		map.put(101, "Karan");
		map.put(108, "Senthil");
//		map.put(203, "Roshan");
//		map.put(506, "Darma");
//		map.put(709, "Nathan");
//		map.put(804, "Sree");
//		map.put(903, "Jai");
		
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