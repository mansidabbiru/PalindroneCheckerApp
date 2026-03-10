import java.util.Scanner;

class PalindromeChecker {
    // Encapsulates palindrome checking logic (Single Responsibility Principle)

    public boolean checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Normalize string (remove spaces and ignore case)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = checker.checkPalindrome(normalized);

        if (result) {
            System.out.println("The given string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        sc.close();
    }
}
