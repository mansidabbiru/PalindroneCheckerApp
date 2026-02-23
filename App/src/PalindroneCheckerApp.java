import java.util.Scanner;

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

        // Convert string to character array
        char[] charArray = cleanStr.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {

            if (charArray[start] != charArray[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}