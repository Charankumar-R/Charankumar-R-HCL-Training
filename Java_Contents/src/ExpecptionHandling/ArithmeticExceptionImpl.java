package ExpecptionHandling;

public class ArithmeticExceptionImpl{

	public static void main(String[] args) {
		int a = 10, b=0, c=0;
		try {
			c=a/b;
			IO.println("The value of c is "+c);
		}catch(ArithmeticException ae) {
			IO.println("The given values for a and b cannot be divided");
			System.err.println(ae);
		}finally {
			IO.println("The value of c is "+c);
		}
	}

}
