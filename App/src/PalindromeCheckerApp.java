import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static boolean twoPointer(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean stackMethod(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) stack.push(s.charAt(i));
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != stack.pop()) return false;
        return true;
    }

    public static boolean dequeMethod(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) deque.addLast(s.charAt(i));
        while (deque.size() > 1) if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }

    public static boolean recursiveMethod(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return recursiveMethod(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start, end;

        start = System.nanoTime();
        twoPointer(input);
        end = System.nanoTime();
        System.out.println("Two-pointer execution time: " + (end - start) + " ns");

        start = System.nanoTime();
        stackMethod(input);
        end = System.nanoTime();
        System.out.println("Stack execution time: " + (end - start) + " ns");

        start = System.nanoTime();
        dequeMethod(input);
        end = System.nanoTime();
        System.out.println("Deque execution time: " + (end - start) + " ns");

        start = System.nanoTime();
        recursiveMethod(input, 0, input.length() - 1);
        end = System.nanoTime();
        System.out.println("Recursive execution time: " + (end - start) + " ns");

        sc.close();
    }
}