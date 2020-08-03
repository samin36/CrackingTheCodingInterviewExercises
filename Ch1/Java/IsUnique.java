// Implement an algorithm to determine if a string has all unique characters. What if you
// cannot use additional data structures? 
import java.util.HashSet;
public class IsUnique {
    public static void main(String[] args) {
        String[] testStrings = {"IamShrey", "hello", "noduplicates", "shreyamin", "thiscontainsduplicates"};
        for (String testString : testStrings) {
            System.out.printf("Testing: %s\n", testString);
            System.out.printf("\tUsing isUniqueA: %b\n", isUniqueA(testString));
            System.out.printf("\tUsing isUniqueB: %b\n", isUniqueB(testString));
        }
    }

    public static boolean isUniqueA(String chars) {
        HashSet<Character> allChars = new HashSet<Character>();
        for (int i = 0; i < chars.length(); i++) {
            char currChar = chars.charAt(i);
            if (allChars.contains(currChar)) {
                return false;
            }
            allChars.add(currChar);
        }
        return true;
    }

    public static boolean isUniqueB(String chars) {
        if (chars.length() > 128) {
            return false;
        }

        int[] charArray = new int[128];
        for (int i = 0; i < chars.length(); i++) {
            char currChar = chars.charAt(i);
            int currVal = charArray[(int) currChar]++;
            if (currVal > 0) {
                return false;
            }
        }
        return true;
    }
}
