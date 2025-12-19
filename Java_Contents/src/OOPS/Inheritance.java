package OOPS;
class Employee{
	int empNo = 10;
	String empName = "Charan";
	
	void displayEmployee() {
		System.out.println("Emp no :"+ empNo +"\nEmp name :"+empName);
	}
}

class Manager extends Employee{
	float variablePay = 1200.05f;
	
	void displayManager() {
		System.out.println("Emp no :"+ empNo +"\nEmp name :"+empName + "\nVariable Pay :"+variablePay);
	}
}
public class Inheritance {
	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.displayEmployee();
	}
}
