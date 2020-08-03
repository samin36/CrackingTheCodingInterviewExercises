#include <cstdlib>
#include <iostream>
#include <string>
#include <vector>

bool isOneAway(std::string str1, std::string str2) {
    int str1Len = str1.length(), str2Len = str2.length();
    if (abs(str1Len - str2Len) > 1) {
        return false;
    }

    if (str1Len < str2Len) {
        return isOneAway(str2, str1);
    }
    int numMismatches = 0;
    if (str1Len == str2Len) {
        int i = 0;
        while (i < str1Len && numMismatches <= 1) {
            if (str1[i] != str2[i]) {
                numMismatches++;
            }
            i++;
        }
    } else {
        int a = 0, b = 0;
        while (a < str1Len && b < str2Len && numMismatches <= 1) {
            if (str1[a] == str2[b]) {
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

int main() {
    std::vector<std::vector<std::string>> testStrings{{"a", "b", "true"},
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
    for (const auto& testString : testStrings) {
        std::cout << testString[0] << " and " << testString[1] << " should be " << testString[2] << std::endl;
        std::cout << "\t Actually is: " << (isOneAway(testString[0], testString[1]) ? "true" : "false") << std::endl;
    }

    return 0;
}