import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

// Strategy 1: Two-Pointer Array Strategy (from UC11)
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
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

    public String toString() { return "Two-Pointer Array Strategy"; }
}

// Strategy 2: Stack Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        // Push first half to stack
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            stack.push(str.charAt(i));
        }

        // Compare second half with stack (pop order)
        int start = (n + 1) / 2;
        for (int i = start; i < n; i++) {
            if (stack.isEmpty() || stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public String toString() { return "Stack Strategy"; }
}

// Strategy 3: Deque Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to deque
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        // Compare front and back simultaneously
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public String toString() { return "Deque Strategy"; }
}

// Context Class using Strategy Pattern
class PalindromeChecker {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime (Polymorphism)
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String str) {
        return strategy.checkPalindrome(str);
    }

    public String getStrategyName() {
        return strategy.toString();
    }
}

public class PalindroneCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Normalize string
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Test all strategies dynamically
        PalindromeStrategy[] strategies = {
                new TwoPointerStrategy(),
                new StackStrategy(),
                new DequeStrategy()
        };

        for (PalindromeStrategy strategy : strategies) {
            checker.setStrategy(strategy);
            boolean result = checker.checkPalindrome(normalized);

            System.out.printf("%s: %s%n",
                    checker.getStrategyName(),
                    result ? "Palindrome ✓" : "NOT a Palindrome ✗");
        }

        sc.close();
    }
}
