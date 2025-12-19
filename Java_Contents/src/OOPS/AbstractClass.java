package OOPS;

abstract class MobilePhone{
	int model = 121;
	abstract void calling();
	void browsing() {
		System.out.println("Browesing in Phone");
	}
}

class Samsung extends MobilePhone{
	int model = 123;
	void calling() {
		System.out.println("Calling from Samsung :"+model);
	}
	void browsing() {
		System.out.println("Browsing from Samsung :"+model);
	}
}

class Iphone extends Samsung{
	void browsing() {
		System.out.println("Browsing from Iphone");
	}
}

public class AbstractClass {
	void main() {
		Samsung sm = new Samsung();
		sm.calling();
		sm.browsing();
		
		MobilePhone mp = new Samsung();
		mp.calling();
		mp.browsing();
		
		Iphone ip = new Iphone();
		ip.calling();
		ip.browsing();
	}
}
