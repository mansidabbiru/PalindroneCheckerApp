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


        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String reversed = "";


        for (int i = cleanStr.length() - 1; i >= 0; i--) {
            reversed = reversed + cleanStr.charAt(i);
        }


        return cleanStr.equals(reversed);
    }
}