package Basic_Program;

import java.util.Scanner;

public class remove_dupli {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you need in the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the numbers one by one: ");

        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Before removing duplicates: ");
        
        for(int num : arr) {
        	System.out.print(num+" ");
        }
        System.out.println();
        System.out.println("After removing duplicates: ");

        for(int i=0;i<n;i++){
            boolean repeat = false;

            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    repeat = true;
                    break;
                }
            }
            if(!repeat)
                System.out.print(arr[i] + " ");
        }
        sc.close();
	}
}
