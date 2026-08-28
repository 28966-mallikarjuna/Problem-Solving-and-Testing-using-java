import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

public class Solution {

    // Check if number is odd
    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    // Check if number is prime
    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a < 2) {
                return false;
            }

            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    // Check if number is palindrome
    public static PerformOperation isPalindrome() {
        return (int a) -> {
            int original = a;
            int reverse = 0;

            while (a > 0) {
                int digit = a % 10;
                reverse = reverse * 10 + digit;
                a = a / 10;
            }

            return original == reverse;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int condition = sc.nextInt();
            int number = sc.nextInt();

            PerformOperation operation;

            if (condition == 1) {

                operation = isOdd();

                if (operation.check(number)) {
                    System.out.println("ODD");
                } else {
                    System.out.println("EVEN");
                }

            } else if (condition == 2) {

                operation = isPrime();

                if (operation.check(number)) {
                    System.out.println("PRIME");
                } else {
                    System.out.println("COMPOSITE");
                }

            } else if (condition == 3) {

                operation = isPalindrome();

                if (operation.check(number)) {
                    System.out.println("PALINDROME");
                } else {
                    System.out.println("NOT PALINDROME");
                }
            }
        }

        sc.close();
    }
}
