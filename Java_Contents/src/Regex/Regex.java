package Regex;

import java.util.Scanner;

public class Regex {

	public static void main(String[] args) {
		String emailPattern = "^[a-z][a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
		String mobileNo = "(?:\\+?\\d{1,3}[-\\s]?)?\\d{3,5}[-]\\d{4,5}[-]?\\d{0,5}\r\n";
		Scanner sc = new Scanner(System.in);
		char check = 0;
		do {
			IO.println("Enter the email id: ");
			String email = sc.nextLine();
			if (email.matches(emailPattern)) {
				String no = sc.nextLine();
				if (no.matches(mobileNo)) {
					IO.println("Valid Email");
					IO.println("Valid Mobile Number");
				}
				else {
					IO.println("Invalid Number");
				}
			}else {
				IO.println("Invalid Email");
			}
			IO.println("Do you wish to continue");
			check=sc.nextLine().charAt(0);
		}while(check!='n');
	}

}
