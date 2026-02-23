import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Enqueue and Push characters
        for (int i = 0; i < cleanStr.length(); i++) {
            char ch = cleanStr.charAt(i);
            stack.push(ch);     // LIFO
            queue.add(ch);      // FIFO
        }

        // Compare dequeue (queue) with pop (stack)
        while (!stack.isEmpty()) {

            if (!queue.remove().equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }
}
