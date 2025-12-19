package Basic_Program;

import java.util.HashMap;
import java.util.Scanner;

public class frequency_of_element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String You want to see how many times each elements are present: ");
		
		String str = sc.nextLine();
		str = str.replaceAll("[^a-zA-Z0-9]", ""); 
		
		HashMap<Character, Integer> map = new HashMap<>(); 
		for(char ch : str.toCharArray()) {
			map.put(ch,map.getOrDefault(ch, 0) + 1);
		}
		
		System.out.println(map);
		sc.close();
	}
}