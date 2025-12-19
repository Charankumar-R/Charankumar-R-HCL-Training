package OOPS;

import java.util.Scanner;

public class Student {
    private String name;
    private int rollNo;
    private double marks;

    public Student() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setMarks(double marks) {
        if (marks < 0) {
            this.marks = 0;
            System.out.println("Marks cannot be negative. Automatically set to 0.");
        } else if (marks > 100) {
            this.marks = 100;
            System.out.println("Marks cannot exceed 100. Automatically set to 100.");
        } else {
            this.marks = marks;
        }
    }

    public double getMarks() {
        return marks;
    }

    public void displayDetails() {
        System.out.println("\n----- Student Details -----");
        System.out.println("Name      : " + name);
        System.out.println("Roll No   : " + rollNo);
        System.out.println("Marks     : " + marks);
    }
}

class StudentDetails {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.println("Enter Student Name: ");
        s.setName(sc.nextLine());

        System.out.println("Enter Roll Number: ");
        s.setRollNo(sc.nextInt());

        System.out.println("Enter Marks (0-100): ");
        s.setMarks(sc.nextDouble());

        s.displayDetails();

        sc.close();
    }
}
