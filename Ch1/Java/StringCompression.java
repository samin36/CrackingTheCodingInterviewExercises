public class StringCompression {


    public static void main(String[] args) {
        String[] testStrings = {"aabcccccaaa", "aaaaabbbbaaaabbddc"};
        for (String testString : testStrings) {
            System.out.printf("%s -> %s\n", testString, CompressString(testString));
        }
    }

    public static String CompressString(String str) {
        int[] charArray = new int[128];
        StringBuilder strBuilder = new StringBuilder();
        char prevChar = str.charAt(0), currChar = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            currChar = str.charAt(i);
            charArray[(int) currChar]++;
            if (prevChar != currChar) {
                strBuilder.append(prevChar);
                strBuilder.append(charArray[(int) prevChar]);
                charArray[(int) prevChar] = 0;
            }
            prevChar = str.charAt(i);
        }
        strBuilder.append(currChar);
        strBuilder.append(charArray[(int) currChar]);
        return strBuilder.toString();
    }
}