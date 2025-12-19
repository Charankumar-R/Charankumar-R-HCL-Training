package ExpecptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CompileTimeException {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "c:\\test.txt";
		try {
			FileInputStream file = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			IO.println(e);
		}
		FileInputStream file = new FileInputStream(fileName);

	}

}
