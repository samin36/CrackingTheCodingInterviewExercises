#include <iostream>
#include <string>
#include <unordered_set>

bool isUniqueA(std::string chars) {
    std::unordered_set<char> allChars;
    for (const auto& currChar : chars) {
        if (allChars.count(currChar)) {
            return false;
        }
        allChars.insert(currChar);
    }
    return true;
}

bool isUniqueB(std::string chars) {
    if (chars.length() > 128) {
        return false;
    }

    int charArray[128] = {0};
    for (const auto& currChar : chars) {
        int currVal = charArray[(int)currChar]++;
        if (currVal > 0) {
            return false;
        }
    }
    return true;
}

int main() {
    std::string testStrings[] = {"IamShrey", "hello", "noduplicates", "shreyamin", "thiscontainsduplicates"};
    for (std::string testString : testStrings) {
        std::cout << "Testing: " << testString << std::endl;
        std::cout << "\tUsing isUniqueA: " << (isUniqueA(testString) ? "true" : "false") << std::endl;
        isUniqueB(testString);
        std::cout << "\tUsing isUniqueB: " << (isUniqueB(testString) ? "true" : "false") << std::endl;
    }
    return 0;
}