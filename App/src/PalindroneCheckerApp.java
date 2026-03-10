import java.util.*;

// Strategy Interface (from UC12)
interface PalindromeStrategy {
    boolean checkPalindrome(String str);
    String getName();
}

// Strategy 1: Two-Pointer Array Strategy
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

    @Override
    public String getName() { return "Two-Pointer"; }
}

// Strategy 2: Stack Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        int n = str.length();

        // Push first half
        for (int i = 0; i < n / 2; i++) {
            stack.push(str.charAt(i));
        }

        // Compare second half
        int start = (n + 1) / 2;
        for (int i = start; i < n; i++) {
            if (stack.isEmpty() || stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Override
    public String getName() { return "Stack"; }
}

// Strategy 3: Deque Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() { return "Deque"; }
}

// Performance measurement utility
class PerformanceTester {
    private static final int ITERATIONS = 100000; // Run each algo 100K times for measurable time

    public static void testPerformance(PalindromeStrategy strategy, String str) {
        // Warm-up JVM
        for (int i = 0; i < 1000; i++) {
            strategy.checkPalindrome(str);
        }

        // Measure execution time
        long startTime = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            strategy.checkPalindrome(str);
        }

        long endTime = System.nanoTime();
        long totalTimeNs = endTime - startTime;
        double avgTimeMicros = (totalTimeNs / 1000.0)
