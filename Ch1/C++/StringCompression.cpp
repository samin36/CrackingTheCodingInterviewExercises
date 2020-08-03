#include <iostream>
#include <string>

std::string compressString(std::string str) {
    int charArray[128] = {0};
    std::string compressedString = "";
    char prevChar = str[0], currChar = str[0];
    for (int i = 0; i < str.length(); i++) {
        currChar = str[i];
        charArray[(int)currChar]++;
        if (prevChar != currChar) {
            compressedString += prevChar;
            compressedString += std::to_string(charArray[(int)prevChar]);
            charArray[(int)prevChar] = 0;
        }
        prevChar = str[i];
    }
    compressedString += currChar;
    compressedString += std::to_string(charArray[(int)currChar]);
    return compressedString;
}

int main() {
    std::string testStrings[2] = {"aabcccccaaa", "aaaaabbbbaaaabbddc"};
    for (std::string testString : testStrings) {
        std::cout << testString << " -> " << compressString(testString) << std::endl;
    }
    return 0;
}