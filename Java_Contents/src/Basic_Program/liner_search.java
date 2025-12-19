package Basic_Program;

import java.util.Scanner;

class liner_search {
	void main() {
		Scanner sc = new Scanner(System.in);
		IO.println("Enter the number of values in the Array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		IO.println("Enter the numbers: ");
		for(int i = 0; i<n;i++){
			nums[i] = sc.nextInt();
		}		
		IO.println("Enter the number that should be search: ");
		int k = sc.nextInt();
		int pos = liner(nums, k) + 1;
		IO.println("Element position is found at " + pos);
		sc.close();
	}
	
	int liner(int[] nums, int k) {
		int n = nums.length;
		for(int i = 0; i<n;i++) {
			if(nums[i] == k) return i;
		}
		return -1;
	}
}
