package Basic_Program;

import java.util.Scanner;

class ForLoop {
	void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0; i<=5; i++) {
			IO.println("Multiplication of 5 and "+ i + " is " + i*5);
			IO.println(n);
		}
		sc.close();
	}
}