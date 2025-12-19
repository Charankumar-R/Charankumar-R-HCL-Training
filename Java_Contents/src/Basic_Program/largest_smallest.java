package Basic_Program;

import java.util.Scanner;

public class largest_smallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array (at least 2): ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("You must enter at least 2 elements. Exiting...");
            sc.close();
            return;
        }

        int arr[] = new int[n];
        System.out.println("Enter " + n + " integer values:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Simple bubble-type sort (ascending)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("\nSorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println("\n\nSecond Smallest element = " + arr[1]);
        System.out.println("Second Largest element  = " + arr[n - 2]);

        sc.close();
    }
}
