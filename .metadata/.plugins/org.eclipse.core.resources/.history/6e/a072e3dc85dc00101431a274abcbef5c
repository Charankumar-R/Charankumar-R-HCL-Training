package Day7;

import java.util.Scanner;

public class BankAccount {
	protected String accountNo;
	protected double balance;

	public BankAccount(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println(amount + " deposited. Updated Balance: " + balance);
		} else {
			System.out.println("Invalid deposit amount!");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println(amount + " withdrawn. Updated Balance: " + balance);
		} else {
			System.out.println("Invalid amount or insufficient balance!");
		}
	}

	public void display() {
		System.out.println("\nAccount No: " + accountNo);
		System.out.println("Balance  : " + balance);
	}
}

class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(String accountNo, double balance, double interestRate) {
		super(accountNo, balance);
		this.interestRate = interestRate;
	}

	public void addInterest() {
		double interest = balance * interestRate / 100;
		balance += interest;
		System.out.println("Interest added: " + interest + ". Updated Balance: " + balance);
	}
}

class SalaryAccount extends BankAccount {
	private double monthlySalary;

	public SalaryAccount(String accountNo, double balance, double monthlySalary) {
		super(accountNo, balance);
		this.monthlySalary = monthlySalary;
	}

	public void creditSalary() {
		balance += monthlySalary;
		System.out.println("Salary credited: " + monthlySalary + ". Updated Balance: " + balance);
	}
}

class BankApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Choose Account Type:");
		System.out.println("1. Savings Account");
		System.out.println("2. Salary Account");
		System.out.print("Enter choice (1 or 2): ");
		int choice = sc.nextInt();
		sc.nextLine(); 

		System.out.print("Enter Account Number: ");
		String accNo = sc.nextLine();

		System.out.print("Enter Opening Balance: ");
		double balance = sc.nextDouble();

		if (choice == 1) {
			System.out.print("Enter Interest Rate (%): ");
			double rate = sc.nextDouble();

			SavingsAccount sa = new SavingsAccount(accNo, balance, rate);

			System.out.print("Enter amount to deposit: ");
			double dep = sc.nextDouble();
			sa.deposit(dep);

			System.out.print("Enter amount to withdraw: ");
			double wd = sc.nextDouble();
			sa.withdraw(wd);

			sa.addInterest();
			sa.display();

		} else if (choice == 2) {
			System.out.print("Enter Monthly Salary: ");
			double salary = sc.nextDouble();

			SalaryAccount salAcc = new SalaryAccount(accNo, balance, salary);

			salAcc.creditSalary();

			System.out.print("Enter amount to withdraw: ");
			double wd = sc.nextDouble();
			salAcc.withdraw(wd);

			salAcc.display();

		} else {
			System.out.println("Invalid choice!");
		}

		sc.close();
	}
}
