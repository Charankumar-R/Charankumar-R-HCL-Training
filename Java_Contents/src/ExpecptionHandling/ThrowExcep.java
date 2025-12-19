package ExpecptionHandling;

import java.util.*;

public class ThrowExcep {

    static void fun(int value) throws IllegalAccessException {
        System.out.println("Inside function.");
        throw new IllegalAccessException(" Entered Input value as:    " + value);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        try {
            fun(value);
        } catch (IllegalAccessException e) {
            System.out.println("caught in main." + e);
        }
        scanner.close();
    }
}
