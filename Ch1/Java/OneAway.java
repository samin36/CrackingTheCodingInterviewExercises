public class OneAway {


    public static void main(String[] args) {
        String[][] testStrings = {{"a", "b", "true"}, 
        {"", "d", "true"},
        {"d", "de", "true"},
        {"pale", "pse", "false"},
        {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
        {"acdsfdsfadsf", "acdsfdfadsf", "true"},
        {"acdsfdsfadsf", "acdsfdsfads", "true"},
        {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
        {"adfdsfadsf", "acdfdsfdsf", "false"},
        {"adfdsfadsf", "bdfdsfadsg", "false"},
        {"adfdsfadsf", "affdsfads", "false"},
        {"pale", "pkle", "true"},
        {"pkle", "pable", "false"}};
        for (String[] testString : testStrings) {
            System.out.printf("%s, %s : %s\n", testString[0], testString[1], testString[2]);
            System.out.printf("\t %b\n", isOneAway(testString[0], testString[1]));
        }

    }

    public static boolean isOneAway(String str1, String str2) {
        int str1Len = str1.length(), str2Len = str2.length();
        if (Math.abs(str1Len - str2Len) > 1) {
            return false;
        }
        if (str1Len < str2Len) { 
            //Ensure that str1's length is ALWAYS greater than str2's length
            return isOneAway(str2, str1); 
        }

        int numMismatches = 0;
        if (str1.length() == str2.length()) {
            //replace or no edit case
            int i = 0;
            while (i < str1Len && numMismatches <= 1) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    numMismatches++;
                }
                i++;
            }
        } else {
            int a = 0, b = 0;
            while (a < str1Len && b < str2Len && numMismatches <= 1) {
                if (str1.charAt(a) == str2.charAt(b)) {
                    a++;
                    b++;
                } else {
                    a++;
                    numMismatches++;
                }
            }
        }
        return numMismatches <= 1;
    } 

}