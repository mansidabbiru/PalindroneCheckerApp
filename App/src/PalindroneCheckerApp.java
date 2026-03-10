import java.util.Stack;
import java.util.Scanner;

public class PalindroneCheckerApp {

    public static boolean isPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        // Push all characters to stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Compare characters while popping
        for (int i = 0; i < input.length(); i++) {
            char ch = stack.pop();
            if (input.charAt(i) != ch) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");

        String text = sc.nextLine();

        text = text.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(text);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        sc.close();
    }
}