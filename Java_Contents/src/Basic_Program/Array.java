package Basic_Program;

import java.util.Scanner;

class Array {
	void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i<n;i++){
			nums[i] = sc.nextInt();
		}
		for(int num:nums) {
			IO.print(num+" ");
		}
		sc.close();
	}
}