public class CheckPermutation {
    public static void main(String[] args) {
        String[][] testStrings = {
            {"shrey", "yersh"},
            {"himiname", "nameimik"},
            {"nameimikkj", "immanekikj"},
            {"apple", "papel"}, 
            {"carrot", "tarroc"}, 
            {"hello", "llloh"}
        };
        for (String[] testString : testStrings) {
            System.out.printf("%s and %s: \n", testString[0], testString[1]);
            System.out.printf("\t %b\n", checkPermutation(testString[0], testString[1]));
        }
    }

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charArray = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            char currChar = str1.charAt(i);
            charArray[(int) currChar]++;
        }
        int numMatches = 0;
        for (int i = 0; i < str2.length(); i++) {
            char currChar = str2.charAt(i);
            if (charArray[(int) currChar] > 0) {
                numMatches++;
                charArray[(int) currChar]--;
            }
        }
        return numMatches == str1.length();
    }
}