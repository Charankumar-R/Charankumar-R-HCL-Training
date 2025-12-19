package OOPS;

public class Polymorphism {
	int empNo;
	String empName;

	int display(int empNo) {
		return empNo;
	}
	
	String display(String empName) {
		return empName;
	}
	int display(int a, int b) {
		return a+b;
	}
	
	int display(float a, int b) {return (int)a-b;}
	int display(int a, int b, int c) {return a-b+c;}
	
	void main() {
		Polymorphism poly = new Polymorphism();
		
		System.out.println("Employee Number: " + poly.display(10));
		System.out.println("Employee Name: " + poly.display("Charan"));
		System.out.println(poly.display(10,10));
		System.out.println(poly.display(10,10,10));
		System.out.println(poly.display(10,10));
	}
}
