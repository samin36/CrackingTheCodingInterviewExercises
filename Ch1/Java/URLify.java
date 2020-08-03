public class URLify {


    public static void main(String[] args) {
        String[] testStrings = {"he llo  ", "Mr John Smith        "};
        for (String testString : testStrings) {
            char[] charArray = testString.toCharArray();
            URLifyA(charArray, getTrueLength(testString));
            System.out.printf("%s -> %s\n", testString, new String(charArray));
        }
    }

    public static int getTrueLength(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                return i + 1;
            }
        }
        return 0;
    }

    public static void URLifyA(char[] url, int trueLength) {
         int arrayIndex = 0;
         char[] newUrl = new char[url.length * 2];
         for (int i = 0; i < trueLength; i++) {
             if (url[i] != ' ') {
                newUrl[arrayIndex++] = url[i];                
             } else {
                newUrl[arrayIndex++] = '%';
                newUrl[arrayIndex++] = '2';
                newUrl[arrayIndex++] = '0';
             }
         }
         for (int i = 0; i < url.length; i++) {
             url[i] = newUrl[i];
         }
    }

    public static void URLifyB(char[] url, int trueLength) {
        int pointerOne = url.length - 1, pointerTwo = trueLength - 1;
        while (pointerTwo >= 0) {
            if (url[pointerTwo] != ' ') {
                url[pointerOne] = url[pointerTwo];
                pointerOne--;
            } else {
                url[pointerOne] = '0';
                url[pointerOne - 1] = '2';
                url[pointerOne - 2] = '%';
                pointerOne-=3;  
            }
            pointerTwo--;
        }
    }

}