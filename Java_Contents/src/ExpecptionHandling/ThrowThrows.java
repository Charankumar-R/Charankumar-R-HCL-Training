package ExpecptionHandling;

import java.util.Scanner;

public class ThrowThrows {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		try {
			int a=sc.nextInt(), b=sc.nextInt();
			int c = a/b;
			throw new NumberFormatException("Hi Nice");
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}catch(NumberFormatException e) {
			IO.println(e);
		}
		catch(Exception e) {
			IO.println(e);
		}
	}

}
