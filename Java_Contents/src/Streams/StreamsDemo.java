package Streams;

import java.util.Arrays;
import java.util.List;

public class StreamsDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(13, 24, 15, 6, 71, 48, 59, 810);

		list.stream()
	//	.sorted()
		.filter(x -> x % 1 == 0)
		.forEach(x -> IO.print(x+" "));
		
		IO.println("\n------------------------------");
		
		list.stream()
		.map(n -> n*n)
		.forEach(n -> IO.print(n+" "));;
		
		IO.println("\n------------------------------");
		
		List<String> l1 = Arrays.asList("Charan", "Bharath", "Karan", "bharani", "Balu", "boss");
		l1.stream()
		.sorted()
		.filter(x -> x.toUpperCase().startsWith("B"))
		.forEach(x -> IO.println(x));
		
		IO.println("\n------------------------------");

		int sumofnums = list.stream()
		.reduce(0, (n1,n2) -> n1+n2);
		IO.println(sumofnums);
		
		IO.println("\n------------------------------");

		list.addFirst(1);
		
	}

}
