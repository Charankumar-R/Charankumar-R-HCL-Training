package ExpecptionHandling;

public class ArrayIndexOutOfBoundsExceptionImpl{

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		try {
			arr[10] = 1;
		}catch(ArrayIndexOutOfBoundsException ae) {
			IO.println("The given index for the array is not valid");
			System.err.println(ae);
		}finally {
			IO.println(null);
		}
	}

}
