package Basic_Program;

import java.util.Scanner;

public class SortChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char arr[] = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        String sorted = new String(arr);
        System.out.println("Original string: " + str);
        System.out.println("Sorted string  : " + sorted);

        sc.close();
    }
}
