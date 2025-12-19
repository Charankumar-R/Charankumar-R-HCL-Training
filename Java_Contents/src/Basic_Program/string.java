package Basic_Program;

class string {
	void main() {
		String s1 = "Charan";
		s1 = s1 + "kumar";
		//IO.print(s1);
		
//		StringBuilder str_builder = new StringBuilder(s1);
//		StringBuffer str_buffer = new StringBuffer(s1);
		
		String str = "Hi, I am Charan";
		String[] str_arr = str.split(" ");
		for(String c:str_arr) {
			IO.println(c);			
		}
	}
}