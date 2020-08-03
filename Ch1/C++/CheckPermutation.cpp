#include <iostream>
#include <string>
#include <vector>

bool checkPermutation(std::string str1, std::string str2) {
    if (str1.length() != str2.length()) {
        return false;
    }

    int charArray[128];
    for (int i = 0; i < str1.length(); i++) {
        char currChar = str1[i];
        charArray[(int)currChar]++;
    }
    int numMatches = 0;
    for (int i = 0; i < str2.length(); i++) {
        char currChar = str2[i];
        if (charArray[(int)currChar] > 0) {
            numMatches++;
            charArray[(int)currChar]--;
        }
    }
    return numMatches == str1.length();
}

int main() {
    std::vector<std::vector<std::string>> testStrings{{"shrey", "yersh"},
                                                      {"himiname", "nameimik"},
                                                      {"nameimikkj", "immanekikj"},
                                                      {"apple", "papel"},
                                                      {"carrot", "tarroc"},
                                                      {"hello", "llloh"}};
    for (auto testString : testStrings) {
        // printf("%s and %s: \n", testString[0], testString[1]);
        std::cout << testString[0] << " and " << testString[1] << ":" << std::endl;
        printf("\t%s\n", checkPermutation(testString[0], testString[1]) ? "true" : "false");
    }
    return 0;
}