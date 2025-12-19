package OOPS;

class Printer implements printable{
	@Override
	public void print() {
		System.out.println(printerName + " is Printing");
	}
}

public class Interface {
	void main() {
		printable pr = new Printer();
		pr.print();
	}
}
