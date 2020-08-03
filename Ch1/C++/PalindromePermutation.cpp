#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>

bool isPalindromePermutation(std::string str) {
    std::unordered_map<char, int> charCount;
    for (const char& currChar : str) {
        if (currChar != ' ') {
            int currCharCount = charCount.count(currChar) > 0 ? charCount.at(currChar) : 0;
            charCount[currChar] = currCharCount + 1;
        }
    }
    int numOddCounts = 0;
    for (const auto& pair : charCount) {
        if (pair.second % 2 != 0) {
            numOddCounts++;
        }
    }
    return numOddCounts <= 1;
}

int main() {
    std::string testStrings[] = {"Rats live on no evil star",
                                 "A man, a plan, a canal, panama",
                                 "Lleve",
                                 "Tacotac",
                                 "asda"};
    for (std::string testString : testStrings) {
        std::string lowerCase = testString;
        std::transform(lowerCase.begin(), lowerCase.end(), lowerCase.begin(), ::tolower);
        std::cout << testString << " -> " << (isPalindromePermutation(lowerCase) ? "true" : "false") << std::endl;
    }

    return 0;
}