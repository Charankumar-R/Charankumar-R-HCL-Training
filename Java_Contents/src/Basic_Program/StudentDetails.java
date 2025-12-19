package Basic_Program;

import java.util.Scanner;

class StudentDetail {
	private String name;
	private long stdId;
	private int stdMarks;
	
	void setStudentDetails(String name, long stdId, int stdMarks) {
		this.name = name;
		this.stdId = stdId;
		this.stdMarks = stdMarks;
	}
	
	String getStudentDetails() {
		return "Student Name: "+this.name+"\nStudent ID :"+this.stdId+"\nStudent Marks :"+this.stdMarks;
	}
}

public class StudentDetails {

	public static void main(String[] args) {
		StudentDetail std1 = new StudentDetail();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your data: ");
		System.out.println("Enter your Name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter your Student ID: ");
		long studentId = sc.nextLong();
		
		System.out.println("Enter your Marks: ");
		int studentMarks = sc.nextInt();
		
		std1.setStudentDetails(name, studentId, studentMarks);
		System.out.println(std1.getStudentDetails());
		
		sc.close();
	}

}
