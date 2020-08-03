import java.util.HashMap;

public class PalindromePermutation {

    public static void main(String[] args) {
        String[] testStrings = {"Rats live on no evil star",
        "A man, a plan, a canal, panama",
        "Lleve",
        "Tacotac",
        "asda"};
        for (String testString : testStrings) {
            System.out.printf("%s -> %b\n", testString, IsPalindromePermutation(testString.toLowerCase()));
        }
    }

    public static boolean IsPalindromePermutation(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar != ' ') {
                int currCharCount = charCount.getOrDefault(currChar, 0);
                charCount.put(currChar, currCharCount + 1);
            }
        }
        int numOddCounts = 0;
        for (Character currChar : charCount.keySet()) {
            if (charCount.get(currChar) % 2 != 0) {
                numOddCounts++;
            }
        }
        return numOddCounts <= 1;
    }


}