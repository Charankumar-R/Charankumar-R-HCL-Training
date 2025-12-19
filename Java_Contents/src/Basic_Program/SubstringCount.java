package Basic_Program;

import java.util.Scanner;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String text = sc.nextLine();

        System.out.print("Enter the substring to search for: ");
        String sub = sc.nextLine();

        if (sub.isEmpty()) {
            System.out.println("Substring is empty. Count = 0");
            sc.close();
            return;
        }

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index = index + sub.length();
        }

        System.out.println("\nMain string : " + text);
        System.out.println("Substring   : " + sub);
        System.out.println("Number of occurrences: " + count);

        sc.close();
    }
}