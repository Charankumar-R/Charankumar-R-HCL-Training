package Basic_Program;

class Construct {
	
	String name;

	Construct() {
		name = "RCK";
	}
	Construct(String nam) {
		name = nam;
	}
	
	void display() {
		IO.println(name);
	}
	
	static void main() {
		Construct cn = new Construct("Charan");
		Construct cn1 = new Construct();
		cn.display();
		cn1.display();
	}
}
