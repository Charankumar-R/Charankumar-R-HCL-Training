package Basic_Program;

class typecasting {

	void main(String[] args) {
//		int n1 = 10;
//		IO.println(n1);
//		
//		long n_f = n1;
//		IO.println(n_f);
//		
//		int n_i = (int)n_f;
//		IO.println(n_i);
//		
//		long a = 999999999999999999l;
//		int b = (int)a;
//		IO.println(b);
		
		float n = (float)6554.92230090;
		long n_l = (long) n;
		IO.println(n_l);
		
		String str = "123";
		int str_num = Integer.parseInt(str); //123
		IO.println(str_num);
		
		char[] arr = str.toCharArray(); //['1','2','3'] memory address = [C@8efb846
		for(char c: arr) {
			IO.println(c);
		}
		IO.println(arr);
		
		char c = 'a';
		IO.println((int)c);
	}

}
