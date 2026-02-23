import java.util.Scanner;

public class PalindroneCheckerApp {
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

            int left = 0;
            int right = cleanStr.length() - 1;

            while (left < right) {
                if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }
