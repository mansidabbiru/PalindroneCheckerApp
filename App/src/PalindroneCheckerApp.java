import java.util.Scanner;
import java.util.Stack;

public class PalindroneCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Palindrome Checker App Management System");
        System.out.print("Enter a word or phrase: ");

        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String str) {

        // Remove special characters and convert to lowercase
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Create Stack
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < cleanStr.length(); i++) {
            stack.push(cleanStr.charAt(i));
        }

        // Pop characters and compare
        for (int i = 0; i < cleanStr.length(); i++) {
            if (cleanStr.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}