package Basic_Program;

import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();

        String trimmed = str.trim();
        if (trimmed.isEmpty()) {
            System.out.println("Number of words: 0");
        } else {
            String words[] = trimmed.split("\\s+");
            System.out.println("The sentence you entered is: \"" + str + "\"");
            System.out.println("Number of words: " + words.length);
        }

        sc.close();
    }
}
